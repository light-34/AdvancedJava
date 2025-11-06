package org.adv.pdfmaker;

import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.multipdf.Overlay;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationRubberStamp;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;

import java.awt.image.RenderedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.util.*;
import java.util.List;

import static org.adv.pdfmaker.PdfProcessingException.wrap;

public class PdfImagesHelper {
    private static final String SAVE_GRAPHICS_STATE = "q\n";
    private static final String RESTORE_GRAPHICS_STATE = "Q\n";
    private static final String CONCATENATE_MATRIX = "cm\n";
    private static final String XOBJECT_DO = "Do\n";
    private static final String SPACE = " ";

    private static final NumberFormat formatDecimal = NumberFormat.getNumberInstance(Locale.US);

    private PDDocument pdfDocument;

    public PdfImagesHelper() {
        pdfDocument = new PDDocument();
    }

    private PdfImagesHelper(InputStream pdf) {

    }

    public PdfImagesHelper stampImage(final File image, final int page, final float x, final float y, final String text) {
        if (page <= 0) throw new IndexOutOfBoundsException("page must be greater or equal to 1");

        PDPage pdPage = pdfDocument.getPage(page - 1);
        List<PDAnnotation> annotations = null;
        try {
            annotations = pdPage.getAnnotations();
        } catch (IOException ex) {
            wrap(ex);
        }
        PDAnnotationRubberStamp rubberStamp = new PDAnnotationRubberStamp();
        rubberStamp.setName(PDAnnotationRubberStamp.NAME_APPROVED);
        if (!StringUtils.isBlank(text)) {
            rubberStamp.setRectangle(new PDRectangle(200, 100));
            rubberStamp.setContents(text);
        }

        PDImageXObject xImage = null;
        try {
            xImage = PDImageXObject.createFromFileByContent(image, pdfDocument);
        } catch (IOException ex) {
            wrap(ex);
        }

        PDRectangle pageArea = pdPage.getCropBox();
        assertPositionAndSize(x, y, xImage, pdPage);

        int formWidth = xImage.getWidth();
        int formHeight = xImage.getHeight();
        int imgWidth = xImage.getWidth();
        int imgHeight = xImage.getHeight();

        PDRectangle rect = new PDRectangle();
        // Most cases lower x & y is 0, but better safe than sorry
        rect.setLowerLeftX(x + pageArea.getLowerLeftX());
        rect.setLowerLeftY(y + pageArea.getLowerLeftY());
        rect.setUpperRightX(x + formWidth);
        rect.setUpperRightY(y + formHeight);

        PDFormXObject form = new PDFormXObject(pdfDocument);
        form.setResources(new PDResources());
        form.setBBox(rect);
        form.setFormType(1);

        try (OutputStream os = form.getStream().createOutputStream()) {
            drawXObject(xImage, form.getResources(), os, x, y, imgWidth, imgHeight);
        } catch (IOException ex) {
            wrap(ex);
        }

        PDAppearanceStream myDic = new PDAppearanceStream(form.getCOSObject());
        PDAppearanceDictionary appearance = new PDAppearanceDictionary(new COSDictionary());
        appearance.setNormalAppearance(myDic);
        rubberStamp.setAppearance(appearance);
        rubberStamp.setRectangle(rect);

        annotations.add(rubberStamp);

        return this;
    }

    private void assertPositionAndSize(float x, float y, PDImageXObject image, PDPage pdPage) {
        PDRectangle pageArea = pdPage.getCropBox();

        if (x < pageArea.getLowerLeftX() || x > pageArea.getUpperRightX()) {
            throw new PdfProcessingException("X position not valid. (" + x + "," + y + ") out of page");
        }

        if (y < pageArea.getLowerLeftY() || y > pageArea.getUpperRightY()){
            throw new PdfProcessingException("Y position not valid. (" + x + "," + y + ") out of page");
        }

        if (x + image.getWidth() > pageArea.getUpperRightX() || y + image.getHeight() > pageArea.getUpperRightY()) {
            throw new PdfProcessingException("Image dos not fit in page");
        }
    }

    private void drawXObject(PDImageXObject xobject, PDResources resources, OutputStream os,
                             float x, float y, float width, float height) throws IOException {

        COSName xObjectId = resources.add(xobject);

        appendRawCommands(os, SAVE_GRAPHICS_STATE);
        appendRawCommands(os, formatDecimal.format(width));
        appendRawCommands(os, SPACE);
        appendRawCommands(os, formatDecimal.format(0));
        appendRawCommands(os, SPACE);
        appendRawCommands(os, formatDecimal.format(0));
        appendRawCommands(os, SPACE);
        appendRawCommands(os, formatDecimal.format(height));
        appendRawCommands(os, SPACE);
        appendRawCommands(os, formatDecimal.format(x));
        appendRawCommands(os, SPACE);
        appendRawCommands(os, formatDecimal.format(y));
        appendRawCommands(os, SPACE);
        appendRawCommands(os, CONCATENATE_MATRIX);
        appendRawCommands(os, SPACE);
        appendRawCommands(os, "/");
        appendRawCommands(os, xObjectId.getName());
        appendRawCommands(os, SPACE);
        appendRawCommands(os, XOBJECT_DO);
        appendRawCommands(os, SPACE);
        appendRawCommands(os, RESTORE_GRAPHICS_STATE);
    }

    private void appendRawCommands(OutputStream os, String commands) throws IOException {
        os.write(commands.getBytes("ISO-8859-1"));
    }

    public PdfImagesHelper overlayImage(final File image, final int page, final int x, final int y, final float boxHeight) {
        if (page <= 0) throw new IndexOutOfBoundsException("page must be greater or equal to 1");

        // Load image only to assert size
        PDImageXObject ximage = null;
        try {
            ximage = PDImageXObject.createFromFileByContent(image, pdfDocument);
        } catch (IOException e) {
            wrap(e);
        }
        PDPage pdPage = pdfDocument.getPage(page - 1);
        assertPositionAndSize(x, y, ximage, pdPage);

        // Create temporal 1-page PDF in memory
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        // Calculate scale factor
        float imageHeight = ximage.getHeight();
        float scale = boxHeight / imageHeight;

        PdfImagesHelper ih = Builder.createEmptyPdf();
        ih.addPage();
        ih.replaceWithImage(image, 1, x, y, scale).writeTo(os);

        Path temp = null;
        try {
            temp = Files.createTempFile("pdf-overlay-", ".pdf");
            Files.write(temp, os.toByteArray());
        } catch (IOException e) {
            wrap(e);
        }

        Map<Integer, String> overlayGuide = new HashMap<Integer, String>();
        //overlayGuide.put(1, temp.getAbsolutePath());

        final String tempAbsolutePath = temp.toAbsolutePath().toString();
        for (int i = 0; i < pdfDocument.getNumberOfPages(); i++) {
            overlayGuide.put(i, tempAbsolutePath);
            //watermark.pdf is the document which is a one page PDF with your watermark image in it.
            //Notice here, you can skip pages from being watermarked.
        }

        Overlay overlay = new Overlay();
        overlay.setInputPDF(pdfDocument);
        overlay.setOverlayPosition(Overlay.Position.FOREGROUND);
        try {
            overlay.setFirstPageOverlayFile(tempAbsolutePath);
            // overlay method needs to ve invoked
            overlay.overlay(new HashMap<>());
        } catch (IOException e) {
            wrap(e);
        }
        return this;
    }

    public PdfImagesHelper replaceWithImage(final File image, final int page, final int x, final int y) {
        return replaceWithImage(image, page, x, y, 1f);
    }

    public PdfImagesHelper replaceWithImage(final File image, final int page, final int x, final int y, final float scale) {

        if (page <= 0) throw new IndexOutOfBoundsException("page must be greater or equal to 1");

        PDPage pdPage = pdfDocument.getPage(page - 1);
        try {
            PDImageXObject pdImage = PDImageXObject.createFromFileByContent(image, pdfDocument);

            // Load image only to assert size
            PDImageXObject ximage = null;
            try {
                ximage = PDImageXObject.createFromFileByContent(image, pdfDocument);
            } catch (IOException e) {
                wrap(e);
            }
            assertPositionAndSize(x, y, ximage, pdPage);

            PDPageContentStream contentStream = new PDPageContentStream(pdfDocument, pdPage);
            contentStream.drawImage(pdImage, x, y, pdImage.getWidth() * scale, pdImage.getHeight() * scale);
            contentStream.close();
        } catch (IOException e) {
            wrap(e);
        }
        return this;
    }

    public List<Images> writeImagesToDir(File path, String basename) throws IOException {

        ImageExtractor ie = new ImageExtractor(pdfDocument, path, basename);
        return ie.process().getImages();
    }

    public List<RenderedImage> getRenderedImages() throws IOException {
        List<RenderedImage> images = new ArrayList<>();
        for (PDPage page : pdfDocument.getPages()) {
            images.addAll(getImagesFromResources(page.getResources()));
        }
        return images;
    }

    private List<RenderedImage> getImagesFromResources(PDResources resources) throws IOException {

        List<RenderedImage> images = new ArrayList<>();
        for (COSName xObjectName : resources.getXObjectNames()) {
            PDXObject xObject = resources.getXObject(xObjectName);
            if (xObject instanceof PDImageXObject) {
                images.add(((PDImageXObject) xObject).getImage());
            } else if (xObject instanceof PDFormXObject) {
                images.addAll(getImagesFromResources(((PDFormXObject) xObject).getResources()));
            }
        }
        return images;
    }

    public void writeTo(File file) {
        try {
            pdfDocument.save(file);
        } catch (IOException e) {
            wrap(e);
        }
    }

    public void writeTo(OutputStream outputStream) {
        try {
            pdfDocument.save(outputStream);
        } catch (IOException e) {
            wrap(e);
        }
    }

    public PdfImagesHelper addPage() {
        PDPage page = new PDPage();
        pdfDocument.getPages().add(page);
        return this;
    }

    public static class Builder {

        /**
         * Builder method to createEmptyPdf an empty PDF
         */
        public static PdfImagesHelper createEmptyPdf() {
            return new PdfImagesHelper();
        }

        /**
         * Builder method
         */
        public static PdfImagesHelper loadPdf(InputStream pdf) {
            return new PdfImagesHelper(pdf);
        }

        /**
         * Builder method
         *
         * @param pdf PDF file
         */
        public static PdfImagesHelper loadPdf(File pdf) {
            try {
                return new PdfImagesHelper(new FileInputStream(pdf));
            } catch (IOException e) {
                wrap(e);
            }
            // don't bother explaining...because Java
            return null;
        }
    }

    public int getPagesCount() {
        return pdfDocument.getNumberOfPages();
    }

}

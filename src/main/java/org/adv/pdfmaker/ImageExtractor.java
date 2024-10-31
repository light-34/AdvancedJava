package org.adv.pdfmaker;

import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.util.Matrix;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImageExtractor extends PDFStreamEngine {
    private final PDDocument pdfDocument;

    private final File output;
    private final String basename;
    private List<Images> images;

    private static final String INVOKE_OPERATOR = "Do";
    private int currentPage;
    private int count = 1;

    public ImageExtractor(PDDocument pdfDocument, File output, String basename) {
        images = new ArrayList<>();
        this.pdfDocument = pdfDocument;
        this.output = output;
        this.basename = basename;
    }

    public ImageExtractor process() {
        try {
            currentPage = 0;
            for (PDPage page : pdfDocument.getPages()) {
                currentPage++;
                processPage(page);
            }
        } catch (IOException e) {
            throw new PdfProcessingException(e);
        }
        return this;
    }

    @Override
    protected void processOperator(Operator operator, List<COSBase> operands) throws IOException {
        String operation = operator.getName();
        if (INVOKE_OPERATOR.equals(operation)) {
            COSName objectName = (COSName) operands.get(0);
            PDXObject xObject = getResources().getXObject(objectName);
            if (xObject instanceof PDImageXObject) {
                PDImageXObject image = (PDImageXObject) xObject;
                Matrix ctmNew = getGraphicsState().getCurrentTransformationMatrix();

                Images im = new Images();
                im.setPage(currentPage);
                im.setxPosition(ctmNew.getTranslateX());
                im.setyPosition(ctmNew.getTranslateY());
                im.setOriginalHeight(image.getHeight());
                im.setOriginalWidth(image.getWidth());
                im.setRenderedHeight(Math.round(ctmNew.getScaleY()));
                im.setRenderedWidth(Math.round(ctmNew.getScaleX()));
                images.add(im);

                if (!output.exists()) output.mkdirs();
                String extension = image.getSuffix();
                File out = new File(output, basename + "-" + currentPage + "-"+ count + "."+ extension);
                ImageIO.write(image.getImage(), extension, new FileOutputStream(out));
                count++;
            } else if (xObject instanceof PDFormXObject) {
                PDFormXObject form = (PDFormXObject) xObject;
                showForm(form);
            }
        } else {
            super.processOperator(operator, operands);
        }
    }

    public List<Images> getImages() {
        return images;
    }
}

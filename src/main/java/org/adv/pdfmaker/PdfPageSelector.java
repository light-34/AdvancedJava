package org.adv.pdfmaker;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.graphics.color.PDOutputIntent;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.adv.pdfmaker.PdfProcessingException.wrap;

public class PdfPageSelector {
    private File sourceFile;
    private int[] pages;
    private SelectorOptions options = SelectorOptions.CREATE_NEW;

    private PdfPageSelector() {
    }

    public static PdfPageSelector builder() {
        return new PdfPageSelector();
    }

    public PdfPageSelector file(File file) {
        this.sourceFile = file;
        return this;
    }

    public PdfPageSelector options(SelectorOptions options) {
        this.options = options;
        return this;
    }

    public void writeTo(final File outputFile) {
        try {
            selectPages().save(outputFile);
        } catch (IOException ex) {
            wrap(ex);
        }
    }

    public void writeTo(final OutputStream outputStream) {
        try {
            selectPages().save(outputStream);
        } catch (IOException ex) {
            wrap(ex);
        }
    }

    private PDDocument selectPages() throws IOException {
        final PDDocument document = Loader.loadPDF(sourceFile);
        int pagesCount = document.getNumberOfPages();
        for (int pageIndex : pages) {
            if(pageIndex <= 0 || pageIndex > pagesCount) {
                throw new IllegalArgumentException(String.format("Invalid page index: %d", pageIndex));
            }
        }

        final PDPageTree documentPages = document.getPages();
        final PDDocument output = Arrays.stream(pages)
                .map(num -> num -1 )
                .mapToObj(documentPages::get)
                .collect(new PagesCollector());

        final PDDocumentCatalog catalog = document.getDocumentCatalog();
        final PDDocumentCatalog outputCatalog = output.getDocumentCatalog();
        if (options.isCopyIntentsEnabled()) {
            catalog.getOutputIntents().forEach(outputCatalog::addOutputIntent);
        }

        return output;
    }


    private PDOutputIntent createStandardRGBIntent(PDDocument document) throws IOException {
        InputStream colorProfile = PdfPageSelector.class.getClassLoader().getResourceAsStream("sRGB_v4_ICC_preference.icc");
        PDOutputIntent intent = new PDOutputIntent(document, colorProfile);
        intent.setInfo("sRGB IEC61966-2.1");
        intent.setOutputCondition("sRGB IEC61966-2.1");
        intent.setOutputConditionIdentifier("sRGB IEC61966-2.1");
        intent.setRegistryName("http://www.color.org");
        return intent;
    }

    private List<PDFont> getFonts(PDPage page) throws IOException {
        final List<PDFont> fonts = new ArrayList<>();
        final PDResources resources = page.getResources();
        for (COSName fontName : resources.getFontNames()) {
            try {
                fonts.add(resources.getFont(fontName));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return fonts;
    }


}

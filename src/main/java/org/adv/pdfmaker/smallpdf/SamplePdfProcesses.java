package org.adv.pdfmaker.smallpdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;


public class SamplePdfProcesses {
    public static void main(String[] args) throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);
        Map<Integer, Object> contents = new LinkedHashMap<>();
        contents.put(1, new Header("Header Betul Aktepe"));
        contents.put(3, new SubHeader("This is Sub Header"));
        contents.put(2, new Body("This is the body of the pdf Whether you need this or not depends on your usecase. For example I wanted to write some text right aligned. In that case it was easier to use absolute position, so I created a helper method like this:"));


        writeToPdf(document, page, contents);
        drawImage(document, page, 25, 400, 200, 200);

        document.save("this1.pdf");
        document.close();
    }

    static void writeToPdf(PDDocument document, PDPage page, Map<Integer, Object> contentMap) throws IOException {
        PDType1Font header = new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD);
        PDType1Font subHeader = new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD);
        PDType1Font body = new PDType1Font(Standard14Fonts.FontName.COURIER);

        PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
        contentStream.beginText();

        float yPosition = page.getMediaBox().getHeight() - 50;
        float xPosition = page.getMediaBox().getWidth();
        contentStream.setLeading(16.5f);

        for (Map.Entry<Integer, Object> entry : contentMap.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof Header) {
                float fontSize = 16;
                float textWidth = ((Header) value).getText().length() * fontSize * 0.6f;

                xPosition = (xPosition - textWidth) / 2;
                contentStream.setFont(header, fontSize);
                contentStream.newLineAtOffset(xPosition, yPosition);
                contentStream.showText(((Header) value).getText());
                yPosition = -25;
            } else if (value instanceof SubHeader) {
                contentStream.setFont(subHeader, 14);
                contentStream.newLineAtOffset((-xPosition + 10), yPosition);
                contentStream.showText(((SubHeader) value).getText());
                yPosition = -15;
            } else {
                contentStream.setFont(body, 12);
                contentStream.newLineAtOffset(10, yPosition);
                contentStream.showText(((Body) value).getText());
                yPosition = -15;
            }
        }

        contentStream.endText();
        contentStream.close();
    }

    static void drawImage(PDDocument document, PDPage page, float x, float y, float width, float height) throws IOException {

        PDImageXObject pdImage = PDImageXObject.createFromFile("gekko.png", document);

        PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);

        contentStream.drawImage(pdImage, x, y, width, height);
        contentStream.close();
    }


}

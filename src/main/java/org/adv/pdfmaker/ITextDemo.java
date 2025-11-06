package org.adv.pdfmaker;

import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

public class ITextDemo {
    public static void main(String[] args) {
        pdfWriter(htmlGenerator());
    }

    public static void pdfWriter(String html) {
        try (ByteArrayOutputStream os = new ByteArrayOutputStream()){
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(html);
            renderer.layout();
            renderer.createPDF(os);

            os.writeTo(new FileOutputStream("output.pdf"));

        } catch (Exception ex) {
            ex.printStackTrace();
        }



    }

    public static String htmlGenerator() {
        StringBuilder sb = new StringBuilder()
                .append("<!DOCTYPE html><html lang=\"en\">")
                .append("<head><title>Document</title></head>")
                .append("<body><h1 style=\"text-align: center;\">Hello World</h1><hr /><p style=\"text-align: left; margin-left: 30px;\">This is my story ......</p><div style=\"display:flex; justify-content:center;\"><img src=\"./new_dragon.png\" alt=\"Dragon\" style=\"height: 300px; width: 300px;\" /></div></body>")
                .append("</html>");

        return sb.toString();
    }
}

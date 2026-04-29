package org.adv.pdf;

import com.itextpdf.text.DocumentException;
import io.jstach.jstachio.JStachio;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.IOException;
import java.io.OutputStream;

public class PdfGeneratorService {

    public void generateInvoicePdf(PdfRecord model, String outputPath) throws IOException, DocumentException {

        // 1. Render the Mustache template to an HTML string using JStachio
        String html = JStachio.render(model);

        // 2. Parse and convert to well-formed XHTML using Jsoup
        //    (Flying Saucer requires valid XHTML, not lenient HTML5)
        Document jsoupDoc = Jsoup.parse(html);
        jsoupDoc.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
        String xhtml = jsoupDoc.html();

        // 3. Convert XHTML to PDF with Flying Saucer
        try (OutputStream os = new java.io.FileOutputStream(outputPath)){
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(xhtml);
            renderer.layout();
            renderer.createPDF(os);
        }
    }
}

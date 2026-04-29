package org.adv.pdf;

import java.util.List;

public class PdfMain {
    public static void main(String[] args) throws Exception {

        List<PdfRecord.LineItems> lineItems = List.of(
                new PdfRecord.LineItems("Widget A", 3, 9.99,  29.97),
                new PdfRecord.LineItems("Gadget B", 1, 49.99, 49.99)
        );

        PdfRecord model = new PdfRecord("John Doe", "Sample Content", "2026-04-29", lineItems, 79.96);

        PdfGeneratorService generator = new PdfGeneratorService();
        generator.generateInvoicePdf(model, "invoice.pdf");
        System.out.println("Invoice PDF generated successfully.");
    }
}

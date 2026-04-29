package org.adv.pdf;

import io.jstach.jstache.JStache;

import java.util.List;

@JStache(path = "templates/invoice.mustache")
public record PdfRecord(
        String invoiceNumber,
        String companyName,
        String date,
        List<LineItems> items,
        double total
) {
    public record LineItems(String description, int quantity, double price, double total) {}
}

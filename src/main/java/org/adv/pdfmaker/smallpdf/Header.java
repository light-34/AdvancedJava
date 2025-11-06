package org.adv.pdfmaker.smallpdf;

public class Header {
    private String text;

    public Header(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

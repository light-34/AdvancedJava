package org.adv.pdfmaker;

public class Images {
    private int page;
    private float xPosition;
    private float yPosition;

    private int originalWidth;
    private int originalHeight;

    private int renderedWidth;
    private int renderedHeight;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public float getxPosition() {
        return xPosition;
    }

    public void setxPosition(float xPosition) {
        this.xPosition = xPosition;
    }

    public float getyPosition() {
        return yPosition;
    }

    public void setyPosition(float yPosition) {
        this.yPosition = yPosition;
    }

    public int getOriginalWidth() {
        return originalWidth;
    }

    public void setOriginalWidth(int originalWidth) {
        this.originalWidth = originalWidth;
    }

    public int getOriginalHeight() {
        return originalHeight;
    }

    public void setOriginalHeight(int originalHeight) {
        this.originalHeight = originalHeight;
    }

    public int getRenderedWidth() {
        return renderedWidth;
    }

    public void setRenderedWidth(int renderedWidth) {
        this.renderedWidth = renderedWidth;
    }

    public int getRenderedHeight() {
        return renderedHeight;
    }

    public void setRenderedHeight(int renderedHeight) {
        this.renderedHeight = renderedHeight;
    }
}

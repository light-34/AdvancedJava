package org.adv.imageprocess;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageProcess {
    public BufferedImage resizeImage(int width, int height, File inputFile) throws IOException {

        BufferedImage originalImage = ImageIO.read(inputFile);

        BufferedImage resizedImage = new BufferedImage(width, height, originalImage.getType());
        Graphics2D graphics = resizedImage.createGraphics();
        graphics.drawImage(originalImage, 0, 0, width, height, null);

        graphics.dispose();

        return resizedImage;

    }

    public BufferedImage resizeImageByBilinearResize(int width, int height, File inputFile) throws IOException {
        BufferedImage originalImage = ImageIO.read(inputFile);

        int currentWidth = originalImage.getWidth();
        int currentHeight = originalImage.getHeight();
        BufferedImage resizedImage = originalImage;

        int stepLength = (int) Math.ceil(Math.log(Math.max((double) width / currentHeight, (double) height / currentHeight)) / Math.log(2));

        for (int i = 0; i < stepLength; i++) {
            int nextWidth = (currentWidth + width) / 2;
            int nextHeight = (currentHeight + height) / 2;

            if (i == stepLength - 1) {
                nextWidth = width;
                nextHeight = height;
            }

            BufferedImage nextImage = new BufferedImage(nextWidth, nextHeight, originalImage.getType());
            Graphics2D graphics = nextImage.createGraphics();

            graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            graphics.drawImage(resizedImage, 0, 0, nextWidth, nextHeight, null);
            graphics.dispose();

            resizedImage = nextImage;
            currentWidth = nextWidth;
            currentHeight = nextHeight;
        }

        return resizedImage;
    }
}

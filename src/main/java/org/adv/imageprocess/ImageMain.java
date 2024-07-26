package org.adv.imageprocess;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

public class ImageMain {
    public static void main(String[] args) {
        ImageProcess imageProcess = new ImageProcess();

        try (FileOutputStream fos = new FileOutputStream("new_dragon.png")){

            BufferedImage image = imageProcess.resizeImageByBilinearResize(1470, 1470, new File("dragon.png"));

            ImageIO.write(image, "png", fos);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

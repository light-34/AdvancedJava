package org.adv.pictureprocess;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class PictureEndocerDemo {
    private static final Logger LOG = LogManager.getLogger(PictureEndocerDemo.class);
    public static void main(String[] args) {
        System.out.println("Encode File : \n" + encodePictureToString(new File("eye.png")));
        //String img = "";
        //decodePicture(encodePicture(new File("dragon.png")));
    }

    public static String encodePictureToString(File file) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()){
            BufferedImage image = ImageIO.read(file);
            ImageIO.write(image, "png", baos);
            byte[] bytes = baos.toByteArray();
            return Base64.getEncoder().encodeToString(bytes);
        } catch (IOException e) {
            LOG.atError().log("An error occured while decoding image file: {}", file.getName());
            throw new RuntimeException(e);
        }
    }

    public static byte[] encodePictureToBytes(File file) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()){
            BufferedImage image = ImageIO.read(file);
            ImageIO.write(image, "png", baos);
            byte[] bytes = baos.toByteArray();
            return Base64.getEncoder().encode(bytes);
        } catch (IOException e) {
            LOG.atError().log("An error occured while decoding image file: {}", file.getName());
            throw new RuntimeException(e);
        }
    }

    public static void decodePicture(String encodedImage) {
        byte[] bytes = Base64.getDecoder().decode(encodedImage);
        try (ByteArrayInputStream is = new ByteArrayInputStream(bytes)) {
            BufferedImage image = ImageIO.read(is);
            File file = new File("decoded_image.png");
            ImageIO.write(image, "png", file);
            LOG.atInfo().log("Decoded image successfully and written to file {}", file.getName());
        } catch (IOException e) {
            LOG.atError().log("An error occurred while decoding image string");
            throw new RuntimeException(e);
        }
    }
}

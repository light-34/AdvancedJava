package org.adv.pictureprocess;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

public class PictureEndocerDemo {
    private static final Logger LOG = LogManager.getLogger(PictureEndocerDemo.class);
    public static void main(String[] args) {
        System.out.println("Encode File : \n" + encodePictureToString(new File("dragon.png")));
        //String img = "";
        //decodePicture(encodePicture(new File("dragon.png")));
    }

    public static String encodePictureToString(File file) {
        try {
            byte[] bytes = Files.readAllBytes(file.toPath());
            return Base64.getEncoder().encodeToString(bytes);
        } catch (IOException e) {
            LOG.atError().log("An error occured while decoding image file: {}", file.getName());
            throw new RuntimeException(e);
        }
    }

    public static byte[] encodePictureToBytes(File file) {
        try {
            byte[] bytes = Files.readAllBytes(file.toPath());
            return Base64.getEncoder().encode(bytes);
        } catch (IOException e) {
            LOG.atError().log("An error occured while decoding image file: {}", file.getName());
            throw new RuntimeException(e);
        }
    }

    public static void decodePicture(String encodedImage) {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(encodedImage);
            Files.write(Path.of("decoded_image.png"), decodedBytes);
            LOG.atInfo().log("Decoded image successfully and written to file");
        } catch (IOException e) {
            LOG.atError().log("An error occurred while decoding image string");
            throw new RuntimeException(e);
        }
    }
}

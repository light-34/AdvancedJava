package org.adv.pictureprocess;

import boofcv.abst.distort.FDistort;
import boofcv.io.image.ConvertBufferedImage;
import boofcv.struct.image.GrayU8;
import boofcv.struct.image.Planar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
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

    public static void resizeImage(Path imagePath, Path resizedImagePath, int width, int height) {
        try {
            BufferedImage originalImage = ImageIO.read(imagePath.toFile());
            BufferedImage resizedImage = new BufferedImage(width, height, originalImage.getType());
            Graphics2D graphics = resizedImage.createGraphics();
            //Uses bicubic algorithm to sample pixels — smoother and sharper than the default nearest-neighbor
            graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            //Prioritizes quality over speed during rendering
            graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            //Smooths out jagged edges on curves and diagonal lines
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics.drawImage(originalImage, 0, 0, width, height, null);
            graphics.dispose();
            ImageIO.write(resizedImage, "png", resizedImagePath.toFile());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void resizeImageBoofy(Path imagePath, Path resizedImagePath, int width, int height) {
        try {
            BufferedImage originalImage = ImageIO.read(imagePath.toFile());

            Planar<GrayU8> originalImagePlanar = ConvertBufferedImage.convertFromPlanar(originalImage,  null, true, GrayU8.class);

            Planar<GrayU8> resizeBoofImage = originalImagePlanar.createNew(width, height);

            new FDistort(originalImagePlanar, resizeBoofImage).scaleExt().apply();

            BufferedImage resizedImage = ConvertBufferedImage.convertTo(resizeBoofImage, null, true);
            ImageIO.write(resizedImage, "png", resizedImagePath.toFile());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package org.adv.pictureprocess;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PictureMain {
    public static void main(String[] args) {
        Path originalImagePath = Paths.get("./dragon.png");
        Path resizedImagePath = Paths.get("./new_dragon_800_600.png");
        int width = 800;
        int height = 600;

        PictureEndocerDemo.resizeImage(originalImagePath, resizedImagePath, width, height);
    }
}

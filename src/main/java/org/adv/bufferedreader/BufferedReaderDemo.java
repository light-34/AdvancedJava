package org.adv.bufferedreader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemo {
    public static String readFileContentV1(File file) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){

            reader.lines().forEach(line -> sb.append(line).append(" - "));

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return sb.toString();
    }
}

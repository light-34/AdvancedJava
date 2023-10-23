package org.adv.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class PathFileDemo {
    public static void main(String[] args) {
        Path path = Paths.get("src/main/java/org/adv/nio/folderA/hello.txt");
        try {
            writeToFileDemo(path, readFromFileDemo(Paths.get("src/main/java/org/adv/path.txt")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //This method is used to write text in to a file
    public static void writeToFileDemo(Path path, String text) throws IOException {
        if (Files.notExists(path)) {
            Files.createFile(path);
        }
        if (Files.size(path) != 0) {
            Files.write(path,text.lines().toList(), StandardOpenOption.APPEND);
        } else {
            Files.write(path, text.lines().toList(), StandardOpenOption.CREATE);
        }

    }

    //This method is used to read text from a file
    public static String readFromFileDemo(Path path) throws IOException{
        StringBuilder sb = new StringBuilder();
        Files.readAllLines(path).forEach(line -> sb.append(line).append("\n"));
        return sb.toString();
    }

    //This is used to get File names
    public static void getFileNames(Path path) {
        try {
            Files.list(path).filter(file -> !Files.isDirectory(file)).forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //This method is used to copy a file
    public static void copyAFile(Path sourceLocation, Path destinationLocation) throws IOException{
        if (Files.notExists(destinationLocation)) {
            Files.copy(sourceLocation, destinationLocation);
        } else {
            System.out.println("File is already exist");
        }

    }

    public static void createADirectory(Path path) throws IOException{
        if (Files.notExists(path)) {
            Files.createDirectory(path);
        }
    }
}

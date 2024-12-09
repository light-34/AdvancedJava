package org.adv.nio;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class PathFileDemo {
    public static void main(String[] args) {
        Path path = Paths.get("/Volumes/MacWorkDrive/MY_PROJECTS/JAVA/AdvancedJava");
        //writeToFileDemo(path, readFromFileDemo(Paths.get("src/main/java/org/adv/path.txt")));

//        List<String> filesInSql = List.of("FruitColorMain.java",
//                "FruitColorBO.java",
//                "FruitColorModel.java",
//                "ExcelSheetModel.java");
//
//        List<String> filesInDirectory = getFileNames(path);
//
//        List<String> missingFiles = compareAndGenerateListofMissing(filesInDirectory, filesInSql);
//
//        missingFiles.forEach(System.out::println);

//        List<String> filesInDir = getFileNames(path, "","xlsx");
//        filesInDir.forEach(System.out::println);

        try {
            Files.list(path).filter(pa -> Files.isDirectory(pa)).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static List<String> compareAndGenerateListofMissing(List<String> filesA, List<String> filesB) {

        return filesA.stream().parallel()
                .filter(file -> !filesB.contains(file)).toList();
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
    public static List<String> getFileNames(Path path) {
        List<String> listOfFiles;
        try {

            listOfFiles = Files.list(path)
                    .filter(Files::isRegularFile)
                    .map(filePath -> filePath.getFileName().toString())
                    .toList();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return listOfFiles;
    }

    public static List<String> getFileNames(Path path, String name, String extension) {
        List<String> listOfFiles;

        try {
            if (StringUtils.isNotEmpty(extension)) {
                String fullExtension = "." + extension;
                listOfFiles = Files.list(path)
                        .parallel()
                        .filter(Files::isRegularFile)
                        .map(filePath -> filePath.getFileName().toString())
                        .filter(file -> file.endsWith(fullExtension))
                        .toList();
            } else {
                listOfFiles = Files.list(path)
                        .parallel()
                        .filter(Files::isRegularFile)
                        .map(filePath -> filePath.getFileName().toString())
                        .filter(file -> file.contains(name))
                        .toList();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return listOfFiles;
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

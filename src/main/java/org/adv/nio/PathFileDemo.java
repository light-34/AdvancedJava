package org.adv.nio;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        List<String> filesInDir = getFileNames(path, "","xlsx");
        filesInDir.forEach(System.out::println);

//        try {
//            Files.list(path).filter(pa -> Files.isDirectory(pa)).forEach(System.out::println);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        /*Map<String, Set<String>> physicalFiles = new HashMap<>();

        Set<String> setA = new HashSet<>();
        setA.add("A");
        setA.add("B");
        setA.add("C");
        physicalFiles.put("file1", setA);

        Set<String> setB = new HashSet<>();
        setB.add("X");
        setB.add("Y");
        physicalFiles.put("file2", setB);

        Set<String> setC = new HashSet<>();
        setC.add("P");
        setC.add("Q");
        physicalFiles.put("file3", setC);

        Map<String, List<String>> sqlFiles = new HashMap<>();
        List<String> listA = new ArrayList<>();
        listA.add("B");
        listA.add("C");
        listA.add("D");
        sqlFiles.put("file1", listA);

        List<String> listB = new ArrayList<>();
        listB.add("Y");
        listB.add("Z");
        sqlFiles.put("file2", listB);

        List<String> listC = new ArrayList<>();
        listC.add("M");
        listC.add("N");
        sqlFiles.put("file4", listC);

        comparePhysicalAndSqlFiles(physicalFiles, sqlFiles);*/


    }

    private static void comparePhysicalAndSqlFiles(Map<String, Set<String>> physicalFiles, Map<String, List<String>> sqlFiles) {
        Map<String, Set<String>> tempPhysicalFiles = physicalFiles.entrySet()
                .stream().parallel().collect(Collectors.toMap(Map.Entry::getKey, entry ->  new HashSet(entry.getValue())));
        Map<String, List<String>> tempSqlFiles = sqlFiles.entrySet()
                .stream().parallel().collect(Collectors.toMap(Map.Entry::getKey, entry -> new ArrayList<>(entry.getValue())));

        physicalFiles.forEach((key, values) -> {
            List<String> sqlFileList = sqlFiles.getOrDefault(key, Collections.emptyList());
            Set<String> sqlFileSet = new HashSet<>(sqlFileList);
            values.removeAll(sqlFileSet);
            if (!values.isEmpty()) {
                values.forEach(value -> System.out.println("Physical file: Key: " + key + " Value : " + value));
            }
        });

        tempSqlFiles.forEach((String key, List<String> values) -> {
            Set<String> physicalFileSet = tempPhysicalFiles.getOrDefault(key, Collections.emptySet());
            List<String> physicalFileList = new ArrayList<>(physicalFileSet);
            values.removeAll(physicalFileList);
            if (!values.isEmpty()) {
                values.forEach(value -> System.out.println("Sql file: " + key + ": " + value));
            }
        });
    }

    /*private static void comparePhysicalAndSqlFiles(Map<String, Set<String>> physicalFiles, Map<String, List<String>> sqlFiles) {

        physicalFiles.forEach((key, values) -> {
            List<String> tempSqlFiles = sqlFiles.getOrDefault(key, Collections.emptyList());
            Set<String> sqlFileSet = new HashSet<>(tempSqlFiles);
            values.removeAll(sqlFileSet);
            if (CollectionUtils.isNotEmpty(values)) {
                values.forEach(value -> System.out.println("Physical file: Key: " + key + " Value : " + value));
            }
        });

        sqlFiles.forEach((String key, List<String> values) -> {
            Set<String> tempPhysicalFiles = physicalFiles.getOrDefault(key, Collections.emptySet());
            List<String> physicalFileList = new ArrayList<>(tempPhysicalFiles);
            values.removeAll(physicalFileList);
            if (CollectionUtils.isNotEmpty(values)) {
                values.forEach(value -> System.out.println("Sql file: " + key + ": " + value));
            }
        });
    }*/

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

    private static Set<String> generateFileList(Path phsicalPath, String extension) {
        try (Stream<Path> walk = Files.walk(phsicalPath, 1)) {
            return walk.filter(Files::isRegularFile)
                    .map(filePath -> filePath.getFileName().toString())
                    .filter(fileName -> fileName.toLowerCase().endsWith(extension))
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            return new HashSet<>();
        }
    }
}

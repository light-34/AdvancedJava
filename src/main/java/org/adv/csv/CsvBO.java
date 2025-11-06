package org.adv.csv;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.adv.timepackage.JavaTimeDemo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CsvBO {
    private static final char DELIMITER = ',';
    private static final String NEW_LINE = CSVWriter.DEFAULT_LINE_END;
    private static final char QUOTE = CSVWriter.DEFAULT_QUOTE_CHARACTER;
    private static final char ESCAPE = CSVWriter.DEFAULT_ESCAPE_CHARACTER;
    private static final Logger LOG = LogManager.getLogger(CsvBO.class.getName());

    //TODO: Continue from here - make it more generic
    public String writeDataToCsv(File file, List<Map<String, Object>> data) {
        String result = "";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            CSVWriter csvWriter = new CSVWriter(writer, DELIMITER, QUOTE, ESCAPE, NEW_LINE);

            for (Map<String, Object> row : data) {
                String[] rowData = new String[row.size()];
                int i = 0;
                for (Object value : row.values()) {
                    rowData[i++] = value.toString();
                }
                csvWriter.writeNext(rowData, true);
            }
            result = "The data saved in file";
        } catch (Exception ex) {
            result = ex.getMessage();
        }

        return result;
    }

    public List<CsvDTO> readCsvDataFromFileApi(File file) {
        List<CsvDTO> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            CSVReader csvReader = new CSVReader(reader);
            List<String[]> csvData = csvReader.readAll();
            for (String[] row : csvData) {
                String fileDriveId = row[0];
                String fileGuId = row[1];
                String fileName = row[2];
                String fileExtension = row[3];
                String fileStatus = row[4];
                CsvDTO csvDTO = new CsvDTO(fileGuId, fileDriveId, fileName, fileExtension, fileStatus);
                result.add(csvDTO);
            }

        } catch (Exception ex) {
            LOG.atError().log("An error occurred while reading data from file");
        }

        return result;
    }

    public List<CsvDTO> readCsvDataFromDrive(File file) {
        List<CsvDTO> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            CSVReader csvReader = new CSVReader(reader);
            List<String[]> csvData = csvReader.readAll();
            for (String[] row : csvData) {
                String fileDriveId = row[0];
                String fileName = row[1];
                String fileExtension = row[2];
                String fileStatus = row[3];
                CsvDTO csvDTO = new CsvDTO(fileDriveId, fileName, fileExtension, fileStatus);
                result.add(csvDTO);
            }

        } catch (Exception ex) {
            LOG.atError().log("An error occurred while reading data from file");
        }

        return result;
    }

    public void compareCsvDataAndWriteToFile(List<CsvDTO> fileCsvData, List<CsvDTO> driveCsvData, String customerId) {

        Map<String, List<String>> result = new HashMap<>();
        List<String> fileResultList = new ArrayList<>();
        for (CsvDTO fileDTO : fileCsvData) {
            boolean found = false;
            for (CsvDTO driveDTO : driveCsvData) {
                if (fileDTO.getFileDriveId().equals(driveDTO.getFileDriveId())) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                String fileDriveId = fileDTO.getFileDriveId();
                String fileName = fileDTO.getFileName();
                String fileExtension = fileDTO.getFileExtension();
                String fileStatus = fileDTO.getFileStatus();
                String fileGuid = fileDTO.getFileGuId();
                fileResultList.add("Missing file Info on Drive : " + fileDriveId + " - " + fileName + " - " + fileExtension + " - " + fileStatus + " - " + fileGuid);
            }
        }

        if (!fileResultList.isEmpty()) {
            result.put("FileApi", fileResultList);
            fileResultList.clear();
        }

        for (CsvDTO driveDTO : driveCsvData) {
            boolean found = false;
            for (CsvDTO fileDTO : fileCsvData) {
                if (driveDTO.getFileDriveId().equals(fileDTO.getFileDriveId())) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                String fileDriveId = driveDTO.getFileDriveId();
                String fileName = driveDTO.getFileName();
                String fileExtension = driveDTO.getFileExtension();
                String fileStatus = driveDTO.getFileStatus();
                String fileGuid = driveDTO.getFileGuId();
                fileResultList.add("Missing file Info on File-Api : " + fileDriveId + " - " + fileName + " - " + fileExtension + " - " + fileStatus + " - " + fileGuid);
            }
        }

        if (!fileResultList.isEmpty()) {
            result.put("Drive", fileResultList);
        }

        String path = "/Volumes/MacOs/Users/cezmi.aktepe/Desktop/Compare/txts/";
        String fileName = customerId + "_Compare.txt";

        writeDataToFile(result, (path + fileName));
    }

    public void writeDataToFile(Map<String, List<String>> data, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            String tempKey = "";
            for (Map.Entry<String, List<String>> entry : data.entrySet()) {
                String key = entry.getKey();
                List<String> values = entry.getValue();
                if (!key.equalsIgnoreCase(tempKey)) {
                    writer.append( "  *********  " + key.toUpperCase() + "   *********  \n");
                    tempKey = key;
                }
                writer.append(String.join(NEW_LINE, values));
                writer.flush();
            }

        } catch (Exception ex) {
            LOG.atError().log("An error occurred while writing data to file");
        }

    }
}

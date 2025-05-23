package org.adv.csv;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvMain {
    public static void main(String[] args) {
//        List<Map<String, Object>> data = new ArrayList<>();
//
//        for (int i = 1; i <= 10; i++) {
//            Map<String, Object> map = new HashMap<>();
//            map.put("id", i);
//            map.put("name", "Name" + i);
//            map.put("age", 20 + i);
//            map.put("active", i % 2 == 0); // Boolean value alternating true/false
//            data.add(map);
//        }
//
//        File file = new File("data.csv");
//        CsvBO csv = new CsvBO();
//        csv.writeDataToCsv(file, data);
        CsvBO csv = new CsvBO();
        String path = "/Volumes/MacOs/Users/cezmi.aktepe/Desktop/Compare/csvs/";
        String fileApiFile = "Result_10.csv";
        String driveFile = "Result_7.csv";

        List<CsvDTO> listFile = csv.readCsvDataFromFileApi(new File(path + fileApiFile));
        List<CsvDTO> listDriver = csv.readCsvDataFromDrive(new File(path + driveFile));

        String customerId = "SNB";

        csv.compareCsvDataAndWriteToFile(listFile, listDriver, customerId);

    }
}

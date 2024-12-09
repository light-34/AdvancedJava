package org.adv.csv;

import com.opencsv.CSVWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;

public class CsvBO {
    private static final char DELIMITER = ',';
    private static final String NEW_LINE = CSVWriter.DEFAULT_LINE_END;
    private static final char QUOTE = CSVWriter.DEFAULT_QUOTE_CHARACTER;
    private static final char ESCAPE = CSVWriter.DEFAULT_ESCAPE_CHARACTER;

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
}

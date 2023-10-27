package org.adv.exelfile;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class FruitColorBO {
    public List<FruitColorModel> readExelFile(File file) {
        List<FruitColorModel> fruitColors = new ArrayList<>();

        try (
                FileInputStream fileInputStream = new FileInputStream(file);
                XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream)
        ){


            int numberOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                XSSFSheet sheet = workbook.getSheetAt(i);

                Iterator<Row> rows = sheet.rowIterator();
                while (rows.hasNext()) {
                    Iterator<Cell> cellIterator = rows.next().cellIterator();
                    String fruitName = "";
                    String fruitColor = "";
                    int count = 0;
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        if (count == 0) {
                            fruitName = cell.getStringCellValue();
                            count++;
                        } else if (count == 1){
                            fruitColor = cell.getStringCellValue();
                            fruitColors.add(new FruitColorModel(fruitName, fruitColor));
                        }
                    }
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return fruitColors;
    }

    public void createExelFile(List<FruitColorModel> fruitColorModels, String fileName) {
        String fileSuffix = ".xlsx";
        try (
                FileOutputStream outputStream = new FileOutputStream(fileName + fileSuffix);
                XSSFWorkbook workbook = new XSSFWorkbook()
        ) {

            XSSFSheet sheet = workbook.createSheet("Fruits");

            int rowNum = 0;
            for (FruitColorModel fruit : fruitColorModels) {
                Row row = sheet.createRow(rowNum++);
                Cell cell1 = row.createCell(1);
                cell1.setCellValue(fruit.getFruitName());
                Cell cell2 = row.createCell(2);
                cell2.setCellValue(fruit.getFruitColor());
            }

            workbook.write(outputStream);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public <K, V> void createGenericExelFile(Map<K, V[]> map, String fileName, int sheetCount) {
        String fileSuffix = ".xlsx";
        try (
                FileOutputStream outputStream = new FileOutputStream(fileName + fileSuffix);
                SXSSFWorkbook workbook = new SXSSFWorkbook()
        ) {
            for (int i = 0; i < sheetCount; i++) {
                SXSSFSheet sheet = workbook.createSheet("Sheet " + (i + 1));
                Collection<V[]> values = map.values();
                int j = 0;
                for (V [] value : values) {
                    SXSSFRow row = sheet.createRow((j));
                    int columIndex = 0;
                    for (V data: value) {
                        SXSSFCell cell = row.createCell(columIndex++);
                        cell.setCellValue((String) data);
                    }
                    j++;
                }
            }
            workbook.write(outputStream);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

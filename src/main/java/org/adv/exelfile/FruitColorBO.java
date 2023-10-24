package org.adv.exelfile;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
}

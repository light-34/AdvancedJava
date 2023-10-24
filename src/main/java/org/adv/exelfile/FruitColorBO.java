package org.adv.exelfile;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FruitColorBO {
    public List<FruitColorModel> readExelFile(File file) {
        List<FruitColorModel> fruitColors = new ArrayList<>();

        try (FileInputStream fileInputStream = new FileInputStream(file)){
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

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
                        if (count == 0 && cell.getCellType() != CellType.BLANK) {
                            fruitName = cell.getStringCellValue();
                            count++;
                        } else if (count == 1 && cell.getCellType() != CellType.BLANK){
                            fruitColor = cell.getStringCellValue();
                            count++;
                        } else if (count == 2){
                            fruitColors.add(new FruitColorModel(fruitName, fruitColor));
                            count = 0;
                        }
                    }
                }


            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return fruitColors;
    }
}

package org.adv.exelfile;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
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
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;


public class FruitColorBO {
    public List<FruitColorModel> readExelFile(File file) {
        List<FruitColorModel> fruitColors = new ArrayList<>();

        try (
                FileInputStream fileInputStream = new FileInputStream(file);
                XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream)
        ) {
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
                        } else if (count == 1) {
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

    public List<ExcelSheetModel> readExelFileGeneric(File file) {
        List<ExcelSheetModel> excelSheetModels = new ArrayList<>();

        try (
                FileInputStream fileInputStream = new FileInputStream(file);
                XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream)
        ) {
            int numberOfSheets = workbook.getNumberOfSheets(); //2
            for (int i = 0; i < numberOfSheets; i++) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                ExcelSheetModel excelSheetModel = new ExcelSheetModel(); // 1. gets sheet
                Map<String, ExcelRowModel> excelRowModels = new HashMap<>(); // 2. gets list of rows

                Iterator<Row> rows = sheet.rowIterator();

                int rowCount = 0;
                while (rows.hasNext()) {
                    Iterator<Cell> cellIterator = rows.next().cellIterator();
                    ExcelRowModel excelRowModel = new ExcelRowModel(); // 3. gets row
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        addCellToRow(cell, excelRowModel);
                    }
                    excelRowModels.put(("row_" + rowCount), excelRowModel);
                    rowCount++;
                }

                excelSheetModel.addRow(("sheet_" + i), excelRowModels);

                excelSheetModels.add(excelSheetModel);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return excelSheetModels;
    }

    public void addCellToRow(Cell cell, ExcelRowModel excelRowModel) {
        switch (cell.getCellType()) {
            case STRING -> excelRowModel.addRowData(cell.getStringCellValue());
            case NUMERIC -> {
                if (DateUtil.isCellDateFormatted(cell)) {
                    excelRowModel.addRowData(String.valueOf(cell.getDateCellValue()));
                } else {
                    excelRowModel.addRowData(String.valueOf(cell.getNumericCellValue()));
                }
            }
            case BOOLEAN -> excelRowModel.addRowData(String.valueOf(cell.getBooleanCellValue()));
            case FORMULA -> excelRowModel.addRowData(cell.getCellFormula());
            case BLANK -> excelRowModel.addRowData(null);
            case ERROR -> excelRowModel.addRowData("Error");
            default -> excelRowModel.addRowData("Unknown format");
        }
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
                int cellNum = 0;
                Row row = sheet.createRow(rowNum++);
                Cell cell0 = row.createCell(cellNum);
                cell0.setCellValue(rowNum);
                Cell cell1 = row.createCell(cellNum++);
                cell1.setCellValue(fruit.getFruitName());
                Cell cell2 = row.createCell(cellNum++);
                cell2.setCellValue(fruit.getFruitColor());
            }

            workbook.write(outputStream);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public <K, V> void createGenericExelFile(Map<K, List<V>> map, String fileName) {
        String fileSuffix = ".xlsx";
        try (
                FileOutputStream outputStream = new FileOutputStream(fileName + fileSuffix);
                SXSSFWorkbook workbook = new SXSSFWorkbook()
        ) {
            SXSSFSheet sheet = workbook.createSheet("Sheet");

            Collection<List<V>> values = map.values();

            int rowIndex = 0;
            for (List<V> value : values) {
                SXSSFRow headerRow = sheet.createRow(rowIndex++);

                if (CollectionUtils.isEmpty(values)){
                    continue;
                }

                V firstValue = value.get(0);
                Method[] methods = firstValue.getClass().getDeclaredMethods();

                int cellIndex = 0;
                SXSSFCell headerRowCell = headerRow.createCell(cellIndex++);
                headerRowCell.setCellValue("Nr");
                for (Method method : methods) {
                    if (method.getName().startsWith("get")) {
                        String fieldName = method.getName().substring(3);
                        headerRowCell = headerRow.createCell(cellIndex++);
                        headerRowCell.setCellValue(fieldName);
                    }
                }

                for (V data : value) {
                    SXSSFRow row = sheet.createRow((rowIndex++));
                    int columIndex = 1;

                    SXSSFCell cell = row.createCell(0);
                    cell.setCellValue(rowIndex - 1);

                    for (Method method : methods) {
                        if (method.getName().startsWith("get")) {
                            try {
                                Object cellValue = method.invoke(data);
                                cell = row.createCell(columIndex);
                                createCellsOfRow(cell, cellValue);
                                columIndex++;
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                }
                rowIndex++;
            }
            workbook.write(outputStream);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private <V> void createCellsOfRow(SXSSFCell cell, V data) {
        if (data instanceof String) {
            cell.setCellValue((String) data);
        } else if (data instanceof Integer) {
            cell.setCellValue((Integer) data);
        } else if (data instanceof Double) {
            cell.setCellValue((Double) data);
        }
        else if (data instanceof Boolean) {
            cell.setCellValue((Boolean) data);
        } else {
            cell.setCellValue(data.toString());
        }
    }
}

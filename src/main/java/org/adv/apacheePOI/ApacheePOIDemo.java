package org.adv.apacheePOI;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ApacheePOIDemo {

    public String createWorkbook() {
        try (XSSFWorkbook workbook = new XSSFWorkbook();
             FileOutputStream outputStream = new FileOutputStream("createworkbook.xlsx")){

            workbook.write(outputStream);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return  "it is written successfully";
    }

    public String openWorkbook() {
        String result = "";
        try {
            File file = new File("openworkbook.xlsx");
            FileInputStream fileInputStream = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

            if (file.isFile() && file.exists()) {
                result = "openworkbook.xlsx file open successfully";
            } else {
                result = "ERROR!!! - openworkbook.xlsx file open unsuccessfully";
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    }
}

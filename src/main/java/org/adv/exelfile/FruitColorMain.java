package org.adv.exelfile;

import org.adv.dto.Employee;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitColorMain {
    public static void main(String[] args) {
        FruitColorBO bo = new FruitColorBO();

//        Map<Integer, String []> map = new HashMap<>();
//        map.put(1, new String[] {"Cezmi", "Aktepe", "40"});
//        map.put(2, new String[] {"Zuhal", "Aktepe", "45"});
//
//        bo.createGenericExelFile(map, "Personal", 2);

        List<FruitColorModel> fruitColorModels = List.of(
                new FruitColorModel("Apple", "Green"),
                new FruitColorModel("Banana", "Yellow"),
                new FruitColorModel("Srawberry", "Red"),
                new FruitColorModel("Dragon Fruit", "Purple")
        );

        List<Employee> employees = List.of(
                new Employee("Cezmi", "Aktepe", 40, 500),
                new Employee("Ferid", "Fer", 35, 300),
                new Employee("Zulu", "Dulu", 15, 345),
                new Employee("Ali", "Veli", 34, 456)
        );

        /*Map<Integer, List<String>> map = new HashMap<>();
        map.put(1, List.of("Ali", "Veli", "34", "2540"));
        map.put(2, List.of("Dudu", "Zulu", "31", "3540"));*/

//        Map<Integer, List<Employee>> map = new HashMap<>();
//        map.put(1, employees);
//
//        bo.createGenericExelFile(map, "employee");

        //bo.createExelFile(bo.readExelFile(new File("FruitColors.xlsx")), "FreshFruit" );
        //bo.createExelFile(fruitColorModels, "fruit_colors");
        /*try {
            Thread.sleep(5000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }*/

        bo.readExelFileGeneric(new File("employee.xlsx")).forEach(excelSheetModel -> {

                    for (Map<String, Map<String, ExcelRowModel>> row : excelSheetModel.getSheets()) {
                        row.forEach((k, v) -> {
                                    String values = "";
                                    for (ExcelRowModel val : v.values()) {
                                        for (String va : val.getRowData()) {
                                            values = values + va + ",";
                                        }
                                    }
                                    System.out.println(k + "\n" + "\t" + values);
                                }
                        );
                    }
                }
        );
    }
}

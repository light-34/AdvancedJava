package org.adv.exelfile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FruitColorMain {
    public static void main(String[] args) {
        FruitColorBO bo = new FruitColorBO();

        Map<Integer, String []> map = new HashMap<>();
        map.put(1, new String[] {"Cezmi", "Aktepe", "40"});
        map.put(2, new String[] {"Zuhal", "Aktepe", "45"});

        bo.createGenericExelFile(map, "Personal", 2);


        /*bo.createExelFile(bo.readExelFile(new File("FruitColors.xlsx")), "FreshFruit" );
        try {
            Thread.sleep(5000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        bo.readExelFile(new File("FreshFruit.xlsx")).forEach( fruit -> {
            System.out.println("Fruit : " + fruit.getFruitName() + " and Color : " + fruit.getFruitColor());
        });*/
    }
}

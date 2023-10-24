package org.adv.exelfile;

import java.io.File;

public class FruitColorMain {
    public static void main(String[] args) {
        FruitColorBO bo = new FruitColorBO();
        bo.createExelFile(bo.readExelFile(new File("FruitColors.xlsx")), "FreshFruit" );
        try {
            Thread.sleep(5000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        bo.readExelFile(new File("FreshFruit.xlsx")).forEach( fruit -> {
            System.out.println("Fruit : " + fruit.getFruitName() + " and Color : " + fruit.getFruitColor());
        });
    }
}

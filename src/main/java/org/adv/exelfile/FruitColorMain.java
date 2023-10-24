package org.adv.exelfile;

import java.io.File;

public class FruitColorMain {
    public static void main(String[] args) {
        FruitColorBO bo = new FruitColorBO();
        bo.readExelFile(new File("FruitsColors.xlsx")).forEach( fruit -> {
            System.out.println("Fruit : " + fruit.getFruitName() + " and Color : " + fruit.getFruitColor());
        });
    }
}

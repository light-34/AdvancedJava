package org.adv.enums;

import java.util.EnumSet;

public class EnumsDemo {
    public static void main(String[] args) {
        EnumSet.allOf(Plants.class).forEach(data -> {
            //String info = data.getName() + " " + data.getType() + " " + data.getColor();
            System.out.printf("Name : %s , Type : %s , Color : %s .\n", data.getName(), data.getType(), data.getColor());
        });

    }
}

package org.adv;

import org.adv.BO.AbstractAdvancedBO;
import org.adv.BO.AdvancedBO;
import org.adv.DAO.Car;
import org.adv.DAO.Computer;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        getElementList(Arrays.asList(new Car(25, "Toyota"),
                new Computer(34, "IBM")));

        getElementList(Arrays.asList(
                new Car(1500, "Mitsubishi"),
                new Car(2000, "Acura"),
                new Car(3000, "Honda")
        ));

    }

    public static String getElements(AbstractAdvancedBO elements) {
        StringBuilder strB = new StringBuilder()
                .append(elements.getName())
                .append(" ")
                .append(elements.getPrice());
        return strB.toString();
    }

    public static void getElementList(List<? extends AbstractAdvancedBO> list) { //wildcard to extend subitems

        list.forEach(data -> {
            if (data instanceof Computer) {
                System.out.println("Computer name is " + data.getName() + " and price is " + data.getPrice());
            } else {
                System.out.println("Car name is " + data.getName() + " and price is " + data.getPrice());
            }

        });
    }


}
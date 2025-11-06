package org.adv.DAO;

import org.adv.BO.AbstractAdvancedBO;

public class Car extends AbstractAdvancedBO {
    private int price;
    private String name;

    public Car(int price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public int getPrice() {return price;}
    @Override
    public String getName() {return name;}


}

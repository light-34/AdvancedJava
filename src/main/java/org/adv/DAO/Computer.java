package org.adv.DAO;

import org.adv.BO.AbstractAdvancedBO;

public class Computer extends AbstractAdvancedBO {
    private int price;
    private String name;

    public Computer(int price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public int getPrice() {
        return price;
    }
    @Override
    public String getName() {
        return name;
    }
}

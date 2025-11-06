package org.adv.factory;

public class AutomobilesMain {
    public static void main(String[] args) {
        AutomobileFactory factory = new AutomobileFactory();
        Automobiles automobiles = factory.getType("sedan");
        System.out.println(automobiles.getType());
    }
}

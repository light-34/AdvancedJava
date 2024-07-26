package org.adv.factory;

public class AutomobileFactory {
    public Automobiles getType(String type) {
        if (type == null) {
            return null;
        } else if (type.equalsIgnoreCase("sedan")) {
            return new Sedan();
        } else {
            return new Truck();
        }
    }
}

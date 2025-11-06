package org.adv.enums;

public enum Plants {
    APPLE("Apple", "Fruit", "Red"),
    ORANGE("Orange", "Fruit", "Orange"),
    BANANA("Banana", "Fruit", "Yellow"),
    TOMATO("Tomato", "Vegetable", "Red");

    Plants(String name, String type, String color) {
        this.name = name;
        this.type = type;
        this.color = color;
    }

    private final String name;
    private final String type;
    private final String color;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }


}

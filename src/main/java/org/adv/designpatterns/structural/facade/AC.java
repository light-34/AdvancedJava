package org.adv.designpatterns.structural.facade;

public class AC {
    public void on() {
        System.out.println("AC is ON");
    }

    public void off() {
        System.out.println("AC is OFF");
    }

    public void setTemperature(int temp) {
        System.out.println("AC temperature set to " + temp + "°C");
    }
}

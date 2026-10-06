package org.adv.designpatterns.structural.facade;

public class Stereo {
    public void on() {
        System.out.println("Stereo is ON");
    }

    public void off() {
        System.out.println("Stereo is OFF");
    }

    public void setVolume(int volume) {
        System.out.println("Stereo volume set to " + volume);
    }
}

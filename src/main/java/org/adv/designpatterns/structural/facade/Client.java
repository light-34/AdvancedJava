package org.adv.designpatterns.structural.facade;

// Client code - simple and clean
public class Client {
    public static void main(String[] args) {
        HomeAutomationFacade home = new HomeAutomationFacade();

        // Without facade, you'd need to control each device separately
        // With facade, just call simple methods
        home.enterHome();
        home.movieMode();
        home.sleepMode();
        home.wakeUpMode();
        home.leaveHome();
    }
}

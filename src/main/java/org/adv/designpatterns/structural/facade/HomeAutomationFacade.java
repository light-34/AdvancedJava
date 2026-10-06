package org.adv.designpatterns.structural.facade;

/**
 * The Facade design pattern is a structural pattern that provides a simplified,
 * unified interface to a complex subsystem. It hides the complexity of multiple classes
 * working together and presents a single entry point for clients.
 */
// The Facade - simplifies interaction with all subsystems
public class HomeAutomationFacade {
    private Light livingRoomLight;
    private Light bedroomLight;
    private AC ac;
    private Stereo stereo;
    private Door door;
    private SecuritySystem securitySystem;

    public HomeAutomationFacade() {
        this.livingRoomLight = new Light("Living Room");
        this.bedroomLight = new Light("Bedroom");
        this.ac = new AC();
        this.stereo = new Stereo();
        this.door = new Door();
        this.securitySystem = new SecuritySystem();
    }

    // Simplified methods that coordinate multiple subsystems
    public void enterHome() {
        System.out.println("\n=== Entering Home ===");
        door.unlock();
        securitySystem.disarm();
        livingRoomLight.on();
        ac.on();
        ac.setTemperature(22);
    }

    public void leaveHome() {
        System.out.println("\n=== Leaving Home ===");
        livingRoomLight.off();
        bedroomLight.off();
        ac.off();
        stereo.off();
        door.lock();
        securitySystem.arm();
    }

    public void movieMode() {
        System.out.println("\n=== Movie Mode ===");
        livingRoomLight.off();
        stereo.on();
        stereo.setVolume(8);
        ac.setTemperature(20);
    }

    public void sleepMode() {
        System.out.println("\n=== Sleep Mode ===");
        bedroomLight.on();
        livingRoomLight.off();
        ac.setTemperature(18);
        stereo.off();
        door.lock();
    }

    public void wakeUpMode() {
        System.out.println("\n=== Wake Up Mode ===");
        bedroomLight.on();
        ac.setTemperature(22);
        stereo.on();
        stereo.setVolume(3);
    }
}

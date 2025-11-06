package org.adv.greeting;

public class GreetingMain {
    public static void main(String[] args) {
        Greeting greeting = () -> System.out.println("Hello World");
        greeting.printMessage();
        Greeting goodMorning = () -> System.out.println("Good Morning");
        goodMorning.printMessage();
        Greeting calculate = () -> System.out.println(5 + 4 + "hello");
        calculate.printMessage();
    }
}

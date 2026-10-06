package org.adv.greeting;

public class GreetingMain {
    public static void main(String[] args) {
        Greeting greeting = () -> "Hello World";
        System.out.println(greeting.printMessage());
        Greeting goodMorning = () -> "Good Morning";
        System.out.println(goodMorning.printMessage());
        Greeting calculate = () -> (5 + 4 + "hello");
        System.out.println(calculate.printMessage());
    }
}

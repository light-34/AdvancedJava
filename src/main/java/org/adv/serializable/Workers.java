package org.adv.serializable;

import java.io.Serializable;

public class Workers implements Serializable {
    private String name;
    private int age;
    //In Java, the transient keyword is used to indicate that a field should not be serialized
    // when an object is being converted into a byte stream. This means that when you deserialize the object,
    // the transient fields will not retain their original values;
    // instead, they will be set to their default values (e.g., null for objects, 0 for integers, false for booleans, etc.).
    //Why Use transient?
    //Security & Privacy: Sensitive data like passwords, credit card details, or personal information should not be serialized to prevent unauthorized access.
    //Optimization: Large objects or non-serializable objects (like Thread, Socket, etc.) can be marked transient to prevent serialization errors and reduce the size of the serialized data.
    //Prevent Unwanted Serialization: Some fields may be temporary (like cached data) and shouldn't be saved/restored when the object is deserialized.
    private transient String ssn;

    public Workers(String name, int age, String ssn) {
        this.name = name;
        this.age = age;
        this.ssn = ssn;
    }

    public void display() {
        System.out.printf("Name: %s, Age:  %d, SSN: %s", name, age, ssn);
    }
}

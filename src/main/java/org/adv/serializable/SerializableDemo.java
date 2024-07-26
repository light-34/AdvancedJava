package org.adv.serializable;

import java.io.File;

public class SerializableDemo {
    public static void main(String[] args) {
        Person p1 = new Person("Cezmi", "Aktepe", 35);



        SerialiazibleUtil util = new SerialiazibleUtil();
        System.out.println(util.deserializeObject(new File("person.ser")));

    }
}

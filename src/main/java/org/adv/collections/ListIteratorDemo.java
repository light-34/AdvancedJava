package org.adv.collections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.ListIterator;

public class ListIteratorDemo {
    private static final Logger log = LogManager.getLogger(ListIteratorDemo.class.getName());
    public static void main(String[] args) {
        List<String> list = List.of("Ali", "Veli", "Bill", "Jill", "David");
        listIteratorDemo(list);

        String value = "Hello";
        int num = 5;
        System.out.printf("Before == value = %s and num = %d", value, num);

        valueChanger(value, num);

        System.out.printf("After == Value= %s, and Num=%d", value, num);

    }

    public static void listIteratorDemo(List<String> list) {
        ListIterator<String> iter = list.listIterator();

        while (iter.hasNext()) {
            String val = iter.next();
            if (val.startsWith("J")) {
                System.out.println(val);
            }
        }
    }

    public static void valueChanger(String value, Integer num) {
        value = "Hello World";
        num = 220;
    }
}

package org.adv.reflections;

import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionDemo {
    public static void main(String[] args) {
        try {
            Class c = Class.forName(args[0]);
            Method[] m = c.getDeclaredMethods();

            Arrays.stream(m).forEach(System.out::println);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}

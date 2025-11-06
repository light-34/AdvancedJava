package org.adv.reflections;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionDemo1 {
    public static void main(String[] args) {
        //Calling name of the methods in String class
//        Method[] methods = String.class.getMethods();
//        Arrays.stream(methods).forEach(method -> System.out.println(method.getName()));

        Field[] fields = String.class.getFields();
        Arrays.stream(fields).forEach(field -> System.out.println(field.getName()));
    }
}

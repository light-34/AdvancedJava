package org.adv.reflections;

import org.adv.dto.Employee;
import org.adv.dto.EmployeePrivate;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class ReflectionDemo {
    public static void main(String[] args) {
        Integer num = 5;
        ReflectionsDataUtil reflectionsDataUtil = new ReflectionsDataUtil();

        //reflectionsDataUtil.printAString("Hello");

        try {
            System.out.println("Name is : " + ReflectionsDataUtil.alterPrivateField(EmployeePrivate.getEmployeePrivate()));
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

//        try {
//            Field field = System.class.getField("out");
//            Class c = field.getDeclaringClass();
//            System.out.println(c.getConstructors());
//
//            Class cl = Thread.State.class.getEnclosingClass();
//            System.out.println(cl);
//            System.out.println(cl.getEnclosingMethod());
//
//        } catch (NoSuchFieldException e) {
//            throw new RuntimeException(e);
//        }
    }
}

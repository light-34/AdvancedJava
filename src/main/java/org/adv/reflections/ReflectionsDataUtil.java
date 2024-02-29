package org.adv.reflections;

import org.adv.dto.EmployeePrivate;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

public  class  ReflectionsDataUtil<T> {

    /***
     * this method uses Class.getClass()
     * @param obj
     * @return
     */
    public Class<?> getClassName(Object obj) {
        return obj.getClass();
    }

    /**
     * needs fully qualified name of the class such as "java.lang.String"
     * @param str
     * @return
     * @throws ClassNotFoundException
     */
    public Class<?> getClassName(String str) throws ClassNotFoundException{
        return Class.forName(str);
    }

    /**
     * This method output the method name of the given class
     * @param type
     */
    public void getClassMethods(Class<T> type) {
        try {
            Method[] m = type.getDeclaredMethods();

            Arrays.stream(m).forEach(System.out::println);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public  void showVariousMethods(Class<T> type) {
        System.out.println("Super Class of " + type + " is : " + type.getSuperclass()); //get Super Class of given class

        Class<?>[] arrCls = type.getDeclaredClasses();
        System.out.println("***** ALL public classes, enums, interfaces ******");
        Arrays.stream(arrCls).forEach(System.out::println);
    }

    public void printAString(String str) {
        Class cls = str.getClass();

        Method [] methods = cls.getMethods();

    }

    public static String alterPrivateField(EmployeePrivate empPrivate) throws NoSuchFieldException, IllegalAccessException {
        Class<?> empCls = empPrivate.getClass();
        Field nameField = empCls.getDeclaredField("name");

        nameField.setAccessible(true);

        nameField.set(empPrivate, "Cezmi Aktepe");

        return empPrivate.getName();

    }

}

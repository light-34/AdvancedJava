package org.adv.reflections;

import org.reflections.Reflections;

import java.util.Set;

public class ReflectionsSubClass {

    public static void main(String[] args) {
        try {
            Class<?> superClass = Class.forName("org.adv.dto.Employee");

            Set<Class<?>> subClasses = getSubclasses((superClass));

            for (Class<?> subClass : subClasses) {
                System.out.println(subClass.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    public static Set<Class<?>> getSubclasses(final Class<?> superClass) {
        Reflections reflections = new Reflections("org.adv.dto");
        return reflections.getSubTypesOf((Class<Object>) superClass);
    }
}

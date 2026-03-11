package org.adv.comparator;

public class ComparatorMain {
    public static void main(String[] args) {
        ComparatorMethods comparatorMethods = new ComparatorMethods();

        comparatorMethods.sortPersonWithAge().forEach(e -> System.out.println(e.getSalary() + " " + e.getAge() + " " + e.getName()));
        System.out.println("\n");
        //comparatorMethods.sortPersonWithLName().forEach(e -> System.out.println(e.getSalary() + " " + e.getAge() + " " + e.getName()));
        System.out.println("\n");
        comparatorMethods.sortPersonWithSalary().forEach(e -> System.out.println(e.getSalary() + " " + e.getAge() + " " + e.getName()));
        System.out.println("\n");
        comparatorMethods.getNullLastList().forEach(e -> System.out.println(e.getSalary() + " " + e.getAge() + " " + e.getName()));
    }
}

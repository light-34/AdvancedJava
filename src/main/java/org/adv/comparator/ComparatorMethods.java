package org.adv.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorMethods {
    public static class Person {
        private String name;
        private int age;
        private double salary;

        public Person(String name, int age, double salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }
        public String getName() {
            return name;
        }
        public int getAge() {
            return age;
        }
        public double getSalary() {
            return salary;
        }
    }

    private List<Person> persons = new ArrayList<>(
            List.of(new Person("Ali", 25, 20.45),
            new Person("Veli", 39, 45.23),
            new Person("Bill", 22, 15.65),
            new Person("Jill", 27, 17.27),
            new Person("John", 32, 85.33),
            new Person("Lily", 23, 34.56),
            new Person(null, 0, 0.0),
                    new Person(null, 5, 5.5)));


    public List<Person> sortPersonWithAge() {
        Comparator<Person> comparator = Comparator.comparingInt(Person::getAge);
        persons.sort(comparator);
        return persons;
    }

    public List<Person> sortPersonWithLName() {
        Comparator<Person> comparator = Comparator.comparing(Person::getName);
        persons.sort(comparator);
        return persons;
    }

    public List<Person> sortPersonWithSalary() {
        Comparator<Person> comparator = Comparator.comparingDouble(Person::getSalary).reversed();
        persons.sort(comparator);
        return persons;
    }

    public List<Person> getNullLastList() {
        //nullsLast()
        Comparator<Person> comparator = Comparator.comparing(Person::getAge, Comparator.nullsLast(Comparator.naturalOrder()));

        //nullsFirst()
        //Comparator<Person> comparator = Comparator.comparing(Person::getAge, Comparator.nullsFirst(Comparator.naturalOrder()));
        persons.sort(comparator);
        return persons;
    }

}

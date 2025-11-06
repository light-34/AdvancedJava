package org.adv.dto;

public class Employee {
    private String name;
    private String lname;
    private int age;
    private int salary;

    public Employee() {
    }

    public Employee(int age) {
        this.age = age;
    }

    public Employee(String name, String lname, int age, int salary) {
        this.name = name;
        this.lname = lname;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    class Department {
        private String name;

        public Department(String name) {
            this.name = name;
        }
    }

    class Tasks {
        private String name;

        public Tasks(String name) {
            this.name = name;
        }
    }

}

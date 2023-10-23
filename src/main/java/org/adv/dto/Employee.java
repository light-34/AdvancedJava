package org.adv.dto;

public class Employee {
    private String name;
    private String lname;
    private String age;
    private int salary;

    public Employee() {
    }

    public Employee(String name, String lname, String age) {
        this.name = name;
        this.lname = lname;
        this.age = age;
    }

    public Employee(String name, String lname, String age, int salary) {
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

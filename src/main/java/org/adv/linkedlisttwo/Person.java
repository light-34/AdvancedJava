package org.adv.linkedlisttwo;

public class Person {
    private String name;
    private String lName;
    private int age;
    private Person person = null;

    private Person nextPerson = null;

    public Person() {
    }

    public Person(String name, String lName, int age) {
        this.name = name;
        this.lName = lName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getNextPerson() {
        return nextPerson;
    }

    public void setNextPerson(Person nextPerson) {
        this.nextPerson = nextPerson;
    }
}

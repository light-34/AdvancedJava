package org.adv.serializable;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L; //Recommended for version control
    private String fname;
    private String lname;
    private int age;

    public Person() {
    }

    public Person(String fname, String lname, int age) {
        this.fname = fname;
        this.lname = lname;
        this.age = age;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
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
}

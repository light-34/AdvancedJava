package org.adv.workprojects;

public class DataOverloading {
    public static void main(String[] args) {
        int error = 0;

        error = addSome(error);

        System.out.println(error);
    }

    public static int addSome(int num) {
        return num + 10;
    }
}

package org.adv.dto;

public class EmployeePrivate {
    private String name;

    private static EmployeePrivate employeePrivate ;

    private EmployeePrivate() {
    }

    public static EmployeePrivate getEmployeePrivate() {
        if (employeePrivate == null) {
            employeePrivate = new EmployeePrivate();
        }
        return employeePrivate;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }
}

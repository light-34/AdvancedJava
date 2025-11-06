package org.adv.fasterxml;

import org.adv.dto.Employee;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ObjectMapperDemo {
    public static void main(String[] args) {
        String str = "[\"Hello\", \"Merhaba\", \"Nasilsin\"]";

        ObjectMapperMethods methods = new ObjectMapperMethods();

        try {
            Path path = Paths.get("objmapper.json");
//            List<Employee> emp = methods.readJsonObject(path);
//            emp.forEach(e -> System.out.println(e.getName() + " " + e.getLname()));
            //System.out.println(emp.getName() + " " +emp.getLname());

//            List<String> list = methods.readJsonString(str);
//            list.forEach(System.out::println);
            //methods.writeJsonString(new Employee("Zuhal", "Aktepe", 34, 2500));

            methods.readJsonObjectGeneric(path, Employee.class);

        } catch (Exception ex) {
            ex.getMessage();
        }
    }
}

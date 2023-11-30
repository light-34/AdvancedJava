package org.adv.optionals;


import org.adv.dto.Employee;

import java.util.List;
import java.util.Optional;

public class OptionalDemo {



    public void nullableDemo(List<Employee> emp) {
        Optional.of(emp.stream().map(Employee::getName)).ifPresent(System.out::println);
    }

}

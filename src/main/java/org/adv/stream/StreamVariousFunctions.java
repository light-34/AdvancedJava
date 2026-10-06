package org.adv.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamVariousFunctions {
    public record Employee(String firstName, String lastName, int age, double salary, boolean isManager) {
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee("John", "Doe", 30, 50000.0, false),
                new Employee("Jane", "Smith", 40, 60000.0, true),
                new Employee("Emily", "Johnson", 25, 45000.0, false),
                new Employee("Michael", "Brown", 35, 55000.0, true)
        ));

        List<Employee> secondEmployees = new ArrayList<>(List.of(
                new Employee("John", "Doe", 30, 50000.0, false),
                new Employee("Jane", "Smith", 40, 60000.0, true),
                new Employee("Emily", "Johnson", 25, 45000.0, false),
                new Employee("Michael", "Brown", 35, 55000.0, true),
                new Employee("Ali", "Veli", 28, 48000.0, false)
        ));

//        employees.sort(Comparator.comparing(Employee::age));
//        System.out.println("Employees sorted by age:");
//        employees.forEach(e -> System.out.println(e.firstName + " " + e.lastName + " - Age: " + e.age));
//        System.out.println("<<<<<<<<<<<<< >>>>>>>>>>>>>>>");
//        System.out.println("Total salary: " + employees.stream().mapToDouble(Employee::salary).sum() + "$");
//
//        List<Employee> managers = employees.stream().filter(e -> e.isManager).toList();
//        System.out.println("<<<<<<<<<<<<< >>>>>>>>>>>>>>>");
//        System.out.println("Managers:");
//        managers.forEach(e -> System.out.println(e.firstName + " " + e.lastName));
//
//        System.out.println("<<<<<<<<<<<<< >>>>>>>>>>>>>>>");
//        List<Employee> uniqeEmployees = secondEmployees.stream()
//                .filter(e -> employees.stream().noneMatch(emp -> emp.firstName.equals(e.firstName) && emp.lastName.equals(e.lastName)))
//                .toList();
//        System.out.println("Unique employees:");
//        uniqeEmployees.forEach(e -> System.out.println(e.firstName + " " + e.lastName));

        Map<String, List<Employee>> employeeMap = new HashMap<>(Map.of(
                "emp", employees,
                "secondEmp", secondEmployees
        ));

        System.out.println("=== 1. Basic Map Iteration ===");
        employeeMap.forEach((key, value) -> {
            System.out.println("Department: " + key);
            value.forEach(e -> System.out.println("  " + e.firstName + " " + e.lastName));
        });

        System.out.println("\n=== 2. Filter Map Entries (departments with more than 4 employees) ===");
        employeeMap.entrySet().stream()
                .filter(entry -> entry.getValue().size() > 4)
                .forEach(entry -> System.out.println(entry.getKey() + " has " + entry.getValue().size() + " employees"));

        System.out.println("\n=== 3. Transform Map Keys to Uppercase ===");
        Map<String, List<Employee>> upperKeyMap = employeeMap.entrySet().stream()
                .collect(HashMap::new,
                        (map, entry) -> map.put(entry.getKey().toUpperCase(), entry.getValue()),
                        HashMap::putAll);
        upperKeyMap.keySet().forEach(System.out::println);

        System.out.println("\n=== 4. Get All Employees from All Departments (FlatMap) ===");
        List<Employee> allEmployees = employeeMap.values().stream()
                .flatMap(List::stream)
                .distinct()
                .toList();
        System.out.println("Total unique employees: " + allEmployees.size());

        System.out.println("\n=== 5. Group Employees by Manager Status ===");
        Map<Boolean, List<Employee>> byManagerStatus = employees.stream()
                .collect(java.util.stream.Collectors.groupingBy(Employee::isManager));
        System.out.println("Managers: " + byManagerStatus.get(true).size());
        System.out.println("Non-managers: " + byManagerStatus.get(false).size());

        System.out.println("\n=== 6. Group Employees by Age Range ===");
        Map<String, List<Employee>> byAgeRange = employees.stream()
                .collect(java.util.stream.Collectors.groupingBy(e -> {
                    if (e.age < 30) return "Under 30";
                    else if (e.age < 40) return "30-39";
                    else return "40+";
                }));
        byAgeRange.forEach((range, emps) ->
                System.out.println(range + ": " + emps.size() + " employees"));

        System.out.println("\n=== 7. Partition Employees by Salary (above/below 50k) ===");
        Map<Boolean, List<Employee>> bySalary = employees.stream()
                .collect(java.util.stream.Collectors.partitioningBy(e -> e.salary >= 50000));
        System.out.println("High earners (>=50k): " + bySalary.get(true).size());
        System.out.println("Lower earners (<50k): " + bySalary.get(false).size());

        System.out.println("\n=== 8. Map to Employee Name -> Salary ===");
        Map<String, Double> nameSalaryMap = employees.stream()
                .collect(java.util.stream.Collectors.toMap(
                        e -> e.firstName + " " + e.lastName,
                        Employee::salary
                ));
        nameSalaryMap.forEach((name, salary) ->
                System.out.println(name + ": $" + salary));

        System.out.println("\n=== 9. Find Highest Paid Employee per Department ===");
        Map<String, Employee> highestPaidPerDept = employeeMap.entrySet().stream()
                .filter(entry -> !entry.getValue().isEmpty())
                .collect(java.util.stream.Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .max(Comparator.comparing(Employee::salary))
                                .orElseThrow()
                ));
        highestPaidPerDept.forEach((dept, emp) ->
                System.out.println(dept + ": " + emp.firstName + " " + emp.lastName + " ($" + emp.salary + ")"));

        System.out.println("\n=== 10. Calculate Total Salary per Department ===");
        Map<String, Double> totalSalaryPerDept = employeeMap.entrySet().stream()
                .collect(java.util.stream.Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .mapToDouble(Employee::salary)
                                .sum()
                ));
        totalSalaryPerDept.forEach((dept, total) ->
                System.out.println(dept + ": $" + total));

        System.out.println("\n=== 11. Sort Map Entries by Value Size (Descending) ===");
        employeeMap.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .forEach(entry ->
                        System.out.println(entry.getKey() + ": " + entry.getValue().size() + " employees"));

        System.out.println("\n=== 12. Count Employees by First Name ===");
        Map<String, Long> nameCount = allEmployees.stream()
                .collect(java.util.stream.Collectors.groupingBy(
                        Employee::firstName,
                        java.util.stream.Collectors.counting()
                ));
        nameCount.forEach((name, count) ->
                System.out.println(name + ": " + count + " occurrence(s)"));

        System.out.println("\n=== 13. Average Salary by Manager Status ===");
        Map<Boolean, Double> avgSalaryByManager = employees.stream()
                .collect(java.util.stream.Collectors.groupingBy(
                        Employee::isManager,
                        java.util.stream.Collectors.averagingDouble(Employee::salary)
                ));
        System.out.println("Average Manager Salary: $" + avgSalaryByManager.get(true));
        System.out.println("Average Non-Manager Salary: $" + avgSalaryByManager.get(false));

        System.out.println("\n=== 14. Filter and Transform: Get Managers' Names ===");
        List<String> managerNames = employeeMap.values().stream()
                .flatMap(List::stream)
                .filter(Employee::isManager)
                .map(e -> e.firstName + " " + e.lastName)
                .distinct()
                .sorted()
                .toList();
        System.out.println("Managers: " + String.join(", ", managerNames));

        System.out.println("\n=== 15. Merge Multiple Maps ===");
        Map<String, List<Employee>> additionalMap = new HashMap<>(Map.of(
                "thirdEmp", List.of(new Employee("Bob", "Wilson", 45, 70000.0, true))
        ));
        Map<String, List<Employee>> mergedMap = new HashMap<>(employeeMap);
        additionalMap.forEach((key, value) ->
                mergedMap.merge(key, value, (existing, newList) -> {
                    List<Employee> combined = new ArrayList<>(existing);
                    combined.addAll(newList);
                    return combined;
                }));
        System.out.println("Total departments after merge: " + mergedMap.size());

    }
}



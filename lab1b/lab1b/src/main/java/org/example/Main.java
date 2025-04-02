package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.model.Employee;
import org.example.model.PensionPlan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        PensionPlan p1 = new PensionPlan("EX1089",LocalDate.of(2024,4,23),100.00);
        PensionPlan p2 = new PensionPlan("SM2307",LocalDate.of(2018,9,10),350.00);


        Employee e1 = new Employee(101L, "Daniel", "Agar", LocalDate.of(2021,4,23),100000.25,p1);
        Employee e2 = new Employee(102L, "Benard", "Shaw", LocalDate.of(2022,4,17),197750.00,null);
        Employee e3 = new Employee(103L, "Carly", "Agar", LocalDate.of(2023,2,28),842000.75 ,null);
        Employee e4 = new Employee(104L, "Wesley", "Schneider", LocalDate.of(2015,9,10),74500.00,p2);
        Employee e5 = new Employee(105L, "Lu", "Wi", LocalDate.of(2022,5,1),100000.25,null);

        List<Employee> employees = Arrays.asList(e1,e2,e3,e4,e5);

        printEmployeeJson(employees);
        nextQuarterEnroll(employees);
    }

    public static void printEmployeeJson(List<Employee> employees) {

        Comparator<Employee> comparator = Comparator
                .comparing(Employee::getSalary).reversed()
                .thenComparing(Employee::getLastName);

        employees.sort(comparator);

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .setPrettyPrinting()
                .create();

        System.out.println("All Employees");
        System.out.println(gson.toJson(employees));
        System.out.println("---------------------------");

    }

    public static void nextQuarterEnroll(List<Employee> employees){

        LocalDate currentDate = LocalDate.now();
        LocalDate startDate = currentDate.minusYears(3);;
        LocalDate endDate = currentDate.minusYears(3).plusMonths(3);

        System.out.println("Next Quarter Enrollment");
        employees.stream()
                 .filter(employee -> employee.getEmploymentDate().isAfter(startDate) && employee.getEmploymentDate().isBefore(endDate))
                .forEach(employee -> System.out.println(employee.toString()));
    }
}
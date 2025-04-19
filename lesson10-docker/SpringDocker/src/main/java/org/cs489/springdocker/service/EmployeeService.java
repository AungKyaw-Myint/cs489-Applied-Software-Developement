package org.cs489.springdocker.service;

import org.cs489.springdocker.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Optional<Employee> createEmployee(Employee employee);
    List<Employee> getAllEmployees();
}

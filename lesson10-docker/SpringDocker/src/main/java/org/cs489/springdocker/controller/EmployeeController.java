package org.cs489.springdocker.controller;

import lombok.RequiredArgsConstructor;
import org.cs489.springdocker.model.Employee;
import org.cs489.springdocker.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {

        Employee employeeSaved=employeeService.createEmployee(employee).orElseThrow(() ->new RuntimeException("Not " +
                                                                                                              "created"));
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeSaved);
    }
}

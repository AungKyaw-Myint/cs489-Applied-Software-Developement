package org.cs489.springdocker.service.impl;

import lombok.RequiredArgsConstructor;
import org.cs489.springdocker.model.Employee;
import org.cs489.springdocker.repository.EmployeeRepository;
import org.cs489.springdocker.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Optional<Employee> createEmployee(Employee employee) {


        return Optional.ofNullable(employeeRepository.save(employee));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}

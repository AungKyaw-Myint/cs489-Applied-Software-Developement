package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {

    private Long employeeId;
    private String firstName;
    private String lastName;
    private LocalDate employmentDate;
    private Double salary;

    private PensionPlan pensionPlan;
}

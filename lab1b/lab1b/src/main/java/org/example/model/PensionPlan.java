package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PensionPlan {

    private String planReferenceNumber;
    private LocalDate enrollmentDate;
    private Double monthlyContribution;
}

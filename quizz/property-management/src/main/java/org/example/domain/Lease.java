package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lease {

    private Long leaseNo;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double monthlyRentalRate;
    private String tenant;
}

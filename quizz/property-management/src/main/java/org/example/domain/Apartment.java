package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.Period;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Apartment {

    private String      apartmentNo;
    private String      propertyName;
    private Integer     floorNo;
    private Integer     size;
    private Integer     numberOfRooms;
    private List<Lease> leases;


    public double totalRevenueLeases(){

        double revenue = 0;
        for (Lease lease : leases) {
            Period period           = Period.between(lease.getStartDate(), lease.getEndDate());
            int    monthsDifference = period.getYears() * 12 + period.getMonths();
//            System.out.println("Difference: " + monthsDifference);
            revenue+=lease.getMonthlyRentalRate()*monthsDifference;
        }

        return revenue;
    }
}

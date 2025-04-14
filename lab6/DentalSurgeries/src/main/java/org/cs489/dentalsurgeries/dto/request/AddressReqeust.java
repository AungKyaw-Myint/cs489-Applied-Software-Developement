package org.cs489.dentalsurgeries.dto.request;

import jakarta.persistence.Column;

public record AddressReqeust(
        
         int no,
         String street,
         String city,
         String state,
         String zip
) {
}

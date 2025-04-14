package com.cs489.LibrarySystem.dto.request;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public record AddressRequestDto(
        String unitNo,
        String street,
        String city,
        String state,
        Integer zip
) {
}

package com.cs489.LibrarySystem.repository;

import com.cs489.LibrarySystem.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}

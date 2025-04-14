package com.cs489.LibrarySystem.repository;

import com.cs489.LibrarySystem.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

    Optional<Publisher> findByNameIgnoreCase(String name);
    void deleteByName(String name);
    List<Publisher> findAll();

}

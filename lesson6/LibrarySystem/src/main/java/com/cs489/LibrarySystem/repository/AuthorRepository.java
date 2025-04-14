package com.cs489.LibrarySystem.repository;

import com.cs489.LibrarySystem.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

//    Optional<Author> findByFirstNameLastNameEqualsIgnoreCase(String firstName, String lastName);
    Optional<Author> findByFirstNameAndLastNameIgnoreCase(String firstName, String lastName);
}

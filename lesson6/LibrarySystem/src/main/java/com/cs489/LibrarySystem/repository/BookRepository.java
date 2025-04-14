package com.cs489.LibrarySystem.repository;

import com.cs489.LibrarySystem.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByIsbn(String isbn);
    void deleteByIsbn(String isbn);

    @Query("select b from Book b where b.isbn=:isbn")
    Optional<Book> findByBookIsbn(@Param("isbn") String isbn);

    @Query(
            """
            select b from Book b left join fetch b.authors left join fetch b.publisher
            """)
    List<Book> findAllBooksCustom();
}

package com.cs489.LibrarySystem.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private Long id;

    @Column(unique = true, nullable = false)
    private String isbn;

    @Column(nullable = false)
    private String title;

    @ManyToOne(cascade=CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Publisher publisher;

    @ManyToMany(cascade=CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "book_author",
               joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "book_id"),
               inverseJoinColumns=@JoinColumn(name="author_id", referencedColumnName="author_id"))
    private List<Author> authors;

    private Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }
}

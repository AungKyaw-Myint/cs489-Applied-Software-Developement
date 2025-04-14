package com.cs489.LibrarySystem.service;

import com.cs489.LibrarySystem.dto.request.BookRequestDto;
import com.cs489.LibrarySystem.dto.response.BookResponseDto;
import com.cs489.LibrarySystem.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Optional<BookResponseDto> createBook(BookRequestDto requestDto);
    Optional<BookResponseDto> findBookByIsbn(String isbn);

    List<BookResponseDto> findAllBooks();
}

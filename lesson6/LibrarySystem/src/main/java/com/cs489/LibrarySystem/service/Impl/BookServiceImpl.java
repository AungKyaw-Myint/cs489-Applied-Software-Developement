package com.cs489.LibrarySystem.service.Impl;

import com.cs489.LibrarySystem.dto.request.BookRequestDto;
import com.cs489.LibrarySystem.dto.response.BookResponseDto;
import com.cs489.LibrarySystem.mapper.BookMapper;
import com.cs489.LibrarySystem.model.Author;
import com.cs489.LibrarySystem.model.Book;
import com.cs489.LibrarySystem.model.Publisher;
import com.cs489.LibrarySystem.repository.AuthorRepository;
import com.cs489.LibrarySystem.repository.BookRepository;
import com.cs489.LibrarySystem.repository.PublisherRepository;
import com.cs489.LibrarySystem.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;

    @Override
    @Transactional
    public Optional<BookResponseDto> createBook(BookRequestDto requestDto) {

        Optional<Book> findBook=bookRepository.findByBookIsbn(requestDto.isbn());
        if(findBook.isPresent()){
            return Optional.empty();
        }

        Book mapBook =bookMapper.dtoToBook(requestDto);

        if(mapBook.getPublisher() != null) {
            Optional<Publisher> findPublisher =
                    publisherRepository.findByNameIgnoreCase(mapBook.getPublisher().getName());

            if(findPublisher.isPresent()){
                mapBook.getPublisher().setId(findPublisher.get().getId());
            }
        }

        if(!mapBook.getAuthors().isEmpty()){
            mapBook.getAuthors().stream().map(author -> {
                Optional<Author> findAuthor=
                        authorRepository.findByFirstNameAndLastNameIgnoreCase(author.getFirstName(),
                                                                                         author.getLastName());

                if(findAuthor.isPresent()){
                    author.setId(findAuthor.get().getId());
                }
                return author;
            });
        }
        Book result=bookRepository.save(mapBook);
        return Optional.ofNullable(bookMapper.bookToDto(result));
    }

    @Override
    public Optional<BookResponseDto> findBookByIsbn(String isbn) {
        Optional<Book> book=bookRepository.findByIsbn(isbn);
        if(book.isPresent()){
            return Optional.ofNullable(bookMapper.bookToDto(book.get()));
        }
        return Optional.empty();
    }

    @Override
    public List<BookResponseDto> findAllBooks() {
        List<Book> books=bookRepository.findAllBooksCustom();
        return bookMapper.bookToDtoList(books);
    }
}

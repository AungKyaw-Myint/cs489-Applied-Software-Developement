package com.cs489.LibrarySystem.mapper;

import com.cs489.LibrarySystem.dto.request.BookRequestDto;
import com.cs489.LibrarySystem.dto.response.BookResponseDto;
import com.cs489.LibrarySystem.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,uses = {PublisherMapper.class})
public interface BookMapper {

    @Mappings({@Mapping(source = "publisherRequestDto", target = "publisher"),
              @Mapping(source = "authorRequestDto", target = "authors")})
    Book dtoToBook(BookRequestDto bookRequestDto);

    @Mappings({@Mapping(source = "publisher", target = "publisherResponseDto"),
                @Mapping(source = "authors", target ="authorResponseDto")})
    BookResponseDto bookToDto(Book book);

    @Mappings({@Mapping(source = "publisher", target = "publisherResponseDto"),
               @Mapping(source = "authors", target ="authorResponseDto")})
    List<BookResponseDto> bookToDtoList(List<Book> books);
}

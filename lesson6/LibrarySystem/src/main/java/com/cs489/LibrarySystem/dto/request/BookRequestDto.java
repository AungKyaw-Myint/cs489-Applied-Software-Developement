package com.cs489.LibrarySystem.dto.request;

import com.cs489.LibrarySystem.dto.response.AuthorResponseDto;
import com.cs489.LibrarySystem.model.Author;
import com.cs489.LibrarySystem.model.Publisher;

import java.util.List;

public record BookRequestDto(

        String isbn,
        String title,
        PublisherRequestDto publisherRequestDto,
        List<AuthorRequestDto> authorRequestDto

) {
}

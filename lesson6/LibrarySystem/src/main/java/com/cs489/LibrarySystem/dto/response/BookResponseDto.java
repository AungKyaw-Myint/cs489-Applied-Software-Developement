package com.cs489.LibrarySystem.dto.response;

import com.cs489.LibrarySystem.model.Author;
import com.cs489.LibrarySystem.model.Publisher;

import java.util.List;

public record BookResponseDto(
        Long id,
        String isbn,
        String title,
        PublisherResponseDto publisherResponseDto,
        List<AuthorResponseDto> authorResponseDto
) {
}

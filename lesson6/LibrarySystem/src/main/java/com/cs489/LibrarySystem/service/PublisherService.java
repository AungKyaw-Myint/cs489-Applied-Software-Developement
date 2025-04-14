package com.cs489.LibrarySystem.service;

import com.cs489.LibrarySystem.dto.request.PublisherRequestDto;
import com.cs489.LibrarySystem.dto.response.PublisherResponseDto;

import java.util.Optional;

public interface PublisherService {

    Optional<PublisherResponseDto> createPublisher(PublisherRequestDto publisherRequestDto);
    Optional<PublisherResponseDto> updatePublisher(PublisherRequestDto publisherRequestDto,String name);
    void deletePublisher(String name);
}

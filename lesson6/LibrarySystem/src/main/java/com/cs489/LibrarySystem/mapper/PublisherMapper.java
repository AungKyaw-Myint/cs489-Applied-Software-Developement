package com.cs489.LibrarySystem.mapper;

import com.cs489.LibrarySystem.dto.request.PublisherRequestDto;
import com.cs489.LibrarySystem.dto.response.PublisherResponseDto;
import com.cs489.LibrarySystem.model.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PublisherMapper {

    @Mapping(source = "addressRequestDto", target = "address")
    Publisher publisherRequestDtoToPublisher(PublisherRequestDto publisherRequestDto);
    
    @Mapping(source = "address", target = "addressResponseDto")
    PublisherResponseDto publisherToPublisherResponseDto(Publisher publisher);

    @Mapping(source = "address", target = "addressResponseDto")
    List<PublisherResponseDto> publisherToPublisherResponseDtoList(List<Publisher> publishers);
}

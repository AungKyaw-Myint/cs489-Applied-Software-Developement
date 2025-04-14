package com.cs489.LibrarySystem.service.Impl;

import com.cs489.LibrarySystem.dto.request.PublisherRequestDto;
import com.cs489.LibrarySystem.dto.response.PublisherResponseDto;
import com.cs489.LibrarySystem.mapper.PublisherMapper;
import com.cs489.LibrarySystem.model.Publisher;
import com.cs489.LibrarySystem.repository.PublisherRepository;
import com.cs489.LibrarySystem.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private PublisherMapper publisherMapper;

    @Override
    public Optional<PublisherResponseDto> createPublisher(PublisherRequestDto publisherRequestDto) {
        System.out.println("Service :"+publisherRequestDto.name());
        Publisher publisher=publisherRepository.save(publisherMapper.publisherRequestDtoToPublisher(publisherRequestDto));

        PublisherResponseDto publisherResponseDto=publisherMapper.publisherToPublisherResponseDto(publisher);


        return Optional.ofNullable(publisherResponseDto);
    }

    @Override
    public Optional<PublisherResponseDto> updatePublisher(PublisherRequestDto publisherRequestDto,String name) {

        Optional<Publisher> publisher=publisherRepository.findByNameIgnoreCase(name);
        if(publisher.isPresent()){
            Publisher mapPublisher=publisherMapper.publisherRequestDtoToPublisher(publisherRequestDto);
            mapPublisher.setId(publisher.get().getId());
            mapPublisher.getAddress().setId(publisher.get().getAddress().getId());
            publisherRepository.save(mapPublisher);
        }

        return null;
    }

    @Override
    public void deletePublisher(String name) {
//        publisherRepository.findByName(name).ifPresent(publisherRepository::delete);


    }

}

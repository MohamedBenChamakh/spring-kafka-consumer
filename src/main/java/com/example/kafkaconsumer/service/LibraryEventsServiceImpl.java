package com.example.kafkaconsumer.service;

import com.example.kafkaconsumer.entity.LibraryEvent;
import com.example.kafkaconsumer.repositoy.LibraryEventsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LibraryEventsServiceImpl implements LibraryEventsService {

    LibraryEventsRepository libraryEventsRepository;

    public LibraryEventsServiceImpl(LibraryEventsRepository libraryEventsRepository) {
        this.libraryEventsRepository = libraryEventsRepository;
    }

    @Override
    public LibraryEvent saveLibraryEvent(LibraryEvent libraryEvent){
        if(libraryEventsRepository.existsById(libraryEvent.getLibraryEventId())){
            log.error("library event already exists : {} ",libraryEvent);
            return null;
        }
        return libraryEventsRepository.save(libraryEvent);
    }

    @Override
    public LibraryEvent updateLibraryEvent(LibraryEvent libraryEvent){
        if(!libraryEventsRepository.existsById(libraryEvent.getLibraryEventId())){
            log.error("library event not found : {} ",libraryEvent);
            return null;
        }
        return libraryEventsRepository.save(libraryEvent);
    }
}

package com.example.kafkaconsumer.service;

import com.example.kafkaconsumer.entity.LibraryEvent;

public interface LibraryEventsService {
    LibraryEvent saveLibraryEvent(LibraryEvent libraryEvent);

    LibraryEvent updateLibraryEvent(LibraryEvent libraryEvent);
}

package com.example.kafkaconsumer.service;

import com.example.kafkaconsumer.entity.Book;
import org.springframework.stereotype.Service;



public interface LibraryEventsService {
    Book saveBook(Book book);

    Book updateBook(Book book);
}

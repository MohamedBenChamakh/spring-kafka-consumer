package com.example.kafkaconsumer.service;

import com.example.kafkaconsumer.entity.Book;
import com.example.kafkaconsumer.repositoy.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LibraryEventsServiceImpl implements LibraryEventsService {

    BookRepository bookRepository;

    public LibraryEventsServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book saveBook(Book book){
        if(bookRepository.existsById(book.getBookId())){
            log.error("book already exists : {} ",book);
            return null;
        }
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book){
        if(!bookRepository.existsById(book.getBookId())){
            log.error("book not found : {} ",book);
            return null;
        }
        return bookRepository.save(book);
    }
}

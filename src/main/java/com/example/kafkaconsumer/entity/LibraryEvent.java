package com.example.kafkaconsumer.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@Getter
@Setter
public class LibraryEvent {

    private Integer libraryEventId;

    private LibraryEventType libraryEventType;

    private Book book;




}

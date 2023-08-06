package com.example.kafkaconsumer.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@NoArgsConstructor
@Getter
@Setter
@Entity
public class LibraryEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer libraryEventId;

    private LibraryEventType libraryEventType;

    @OneToOne(cascade = CascadeType.ALL)
    private Book book;




}

package com.example.kafkaconsumer.consumer;

import com.example.kafkaconsumer.entity.LibraryEvent;
import com.example.kafkaconsumer.service.LibraryEventsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LibraryEventsConsumer {

    ObjectMapper objectMapper;

    LibraryEventsService libraryEventsService;


    public LibraryEventsConsumer(ObjectMapper objectMapper, LibraryEventsService libraryEventsService) {
        this.libraryEventsService = libraryEventsService;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = {"library-events"})
    public void onMessage(ConsumerRecord<Integer, String> consumerRecord) throws JsonProcessingException {
        var libraryEvent = objectMapper.readValue(consumerRecord.value(), LibraryEvent.class);
        log.info("{}", libraryEvent);
        switch (libraryEvent.getLibraryEventType()) {
            case NEW:
                libraryEventsService.saveLibraryEvent(libraryEvent);
                break;
            case UPDATE:
                libraryEventsService.updateLibraryEvent(libraryEvent);
                break;
        }
    }
}

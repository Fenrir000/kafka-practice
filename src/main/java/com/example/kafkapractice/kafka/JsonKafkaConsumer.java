package com.example.kafkapractice.kafka;

import com.example.kafkapractice.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JsonKafkaConsumer {
    @KafkaListener(topics = "newTopicJson",groupId = "myGroup")
    public void consume(Book book){
        log.info("Json message from producer "+ book.toString());

    }
}

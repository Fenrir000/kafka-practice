package com.example.kafkapractice.kafka;

import com.example.kafkapractice.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JsonKafkaProducer {
    private KafkaTemplate<String, Book> kafkaTemplate;

    @Autowired
    public JsonKafkaProducer(KafkaTemplate<String, Book> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(Book book){
        log.info("Message sent: "+book.toString());
        Message<Book> message= MessageBuilder.withPayload(book)
                .setHeader(KafkaHeaders.TOPIC,"newTopicJson")
                .build();
        kafkaTemplate.send(message);
    }
}

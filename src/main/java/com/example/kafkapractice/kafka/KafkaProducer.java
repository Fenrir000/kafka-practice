package com.example.kafkapractice.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
//Producer that will send message to newTopic
public class KafkaProducer {
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage( String message){
        log.info("message sent "+ message);
        kafkaTemplate.send("newTopic",message);

    }
}

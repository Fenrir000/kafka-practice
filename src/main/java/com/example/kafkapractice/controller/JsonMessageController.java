package com.example.kafkapractice.controller;

import com.example.kafkapractice.kafka.JsonKafkaProducer;
import com.example.kafkapractice.model.Book;
import com.sun.source.tree.LambdaExpressionTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jsonProduce")
//controller that will create messages for newTopicJson
public class JsonMessageController {
    private JsonKafkaProducer jsonKafkaProducer;

    @Autowired
    public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }
@PostMapping("/produce")
    public ResponseEntity<String>  produceJson(@RequestBody Book book){
        jsonKafkaProducer.sendMessage(book);
        return ResponseEntity.ok("Message send");
    }
}

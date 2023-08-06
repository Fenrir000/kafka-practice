package com.example.kafkapractice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {


    //create new topic:
    @Bean
    public NewTopic myTopic(){
        return TopicBuilder.name("newTopic")
                .build();
    }

    @Bean
    public NewTopic myTopicJson(){
        return TopicBuilder.name("newTopicJson")
                .build();
    }
}

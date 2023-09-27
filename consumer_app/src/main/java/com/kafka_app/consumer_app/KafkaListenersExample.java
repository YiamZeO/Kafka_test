package com.kafka_app.consumer_app;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListenersExample {
    @KafkaListener(topics = "test_topic")
    void listener(String data) {
        System.out.println(data);
    }

}

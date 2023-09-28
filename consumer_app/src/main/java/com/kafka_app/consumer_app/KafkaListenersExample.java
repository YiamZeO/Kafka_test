package com.kafka_app.consumer_app;

import com.kafka_app.classes.UserInfo;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListenersExample {
    @KafkaListener(topics = "${my.kafka.topic.name}")
    void listener(UserInfo userInfo) {
        System.out.println(userInfo);
    }

}

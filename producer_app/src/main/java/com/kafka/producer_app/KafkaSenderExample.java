package com.kafka.producer_app;

import com.kafka_app.classes.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class KafkaSenderExample {
    private final KafkaTemplate<String, UserInfo> kafkaTemplate;
    @Value("${my.kafka.topic.name}")
    private String topicName;
    @Autowired
    KafkaSenderExample(KafkaTemplate<String, UserInfo> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    void sendMessageInTopic(UserInfo userInfo) {
        CompletableFuture<SendResult<String, UserInfo>> future = kafkaTemplate.send(topicName, userInfo);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent message=[ User name: " + userInfo.getName()+
                        ", user password: " + userInfo.getPassword() +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message due to : " + ex.getMessage());
            }
        });
    }
}

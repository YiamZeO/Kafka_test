package com.kafka_app.consumer_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class ConsumerAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerAppApplication.class, args);
    }

}

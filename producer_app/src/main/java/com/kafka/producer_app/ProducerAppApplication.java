package com.kafka.producer_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class ProducerAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerAppApplication.class, args);
    }
}

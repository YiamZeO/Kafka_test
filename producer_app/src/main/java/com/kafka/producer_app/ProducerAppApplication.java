package com.kafka.producer_app;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication
public class ProducerAppApplication {

    public static void main(String[] args) {
        String bootstrapServers = "localhost:9092";
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer");
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
        ProducerRecord<String, String> producerRecord =
                new ProducerRecord<>("test_topic", "Hello from producer");
        producer.send(producerRecord, (metadata, exception) -> {
            if (exception == null) {
                System.out.println("Message sent successfully. Offset: " + metadata.offset());
            } else {
                System.err.println("Error occurred while sending message: " + exception.getMessage());
            }
        });        producer.flush();
        producer.close();
    }
}

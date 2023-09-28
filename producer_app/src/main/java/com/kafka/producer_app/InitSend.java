package com.kafka.producer_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class InitSend {
    private final KafkaSenderExample kafkaSenderExample;

    @Autowired
    public InitSend(KafkaSenderExample kafkaSenderExample) {
        this.kafkaSenderExample = kafkaSenderExample;
    }

    @EventListener
    public void initiateSendingMessage(ApplicationReadyEvent event) {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            String message = "Producer message number" + i;
            kafkaSenderExample.sendMessageInTopic(message);
        }
    }
}
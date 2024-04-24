package com.example.orderstatusservice.kafka;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaMessagingTemplate {

    @Value("${topic.status-order}")
    private String sendClientTopic;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendOrder(OrderEvent orderEvent) {
        kafkaTemplate.send(sendClientTopic, orderEvent.getStatus(), orderEvent);
    }

}

package com.example.orderstatusservice.service;


import com.example.orderstatusservice.kafka.KafkaMessagingTemplate;
import com.example.orderstatusservice.kafka.OrderEvent;
import com.example.orderstatusservice.model.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;


@Slf4j
@Component
@RequiredArgsConstructor
public class ServiceProducer {

    private final KafkaMessagingTemplate kafkaMessagingService;
    private final ModelMapper modelMapper;
    private UUID uuid = UUID.randomUUID();



    public void sendOrderEvent() {
        String status = STR."CREATED\{uuid}";
        Order order = Order.builder().status(status).date(Instant.now()).build();
        kafkaMessagingService.sendOrder(modelMapper.map(order, OrderEvent.class));
        log.info("Send order from producer {}", order);

    }
}
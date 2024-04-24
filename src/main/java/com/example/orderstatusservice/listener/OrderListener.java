
package com.example.orderstatusservice.listener;

import com.example.orderstatusservice.service.ServiceProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
@Slf4j
@RequiredArgsConstructor
public class OrderListener {
    private final ServiceProducer producer;

    @KafkaListener(id = "foo", topics = "${topic.send-order}")
    public void listen(String data) {
        log.info("Received OrderEvent: {}", data);
        producer.sendOrderEvent();

    }


}

package com.devwdougherty.rabbitqueuedataprovider;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    private final RabbitMqService rabbitMqService;

    public ProducerController(RabbitMqService rabbitMqService) {
        this.rabbitMqService = rabbitMqService;
    }

    @PostMapping("/producer")
    public ResponseEntity producer() {

        rabbitMqService.connectToRabbitMqBroker();

        return ResponseEntity.ok().build();
    }
}

package com.example.sbrabbitmqexchanges;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sb-rabbitmq/direct/")
@RequiredArgsConstructor
public class RabbitMQDirectController {

    private final AmqpTemplate amqpTemplate;

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("exchangeName") String exchange, 
                           @RequestParam("routingKey") String routingKey,
                           @RequestParam("messageData") String messageData) {
        amqpTemplate.convertAndSend(exchange, routingKey, messageData);

        return "Message sent to the RabbitMQ Successfully";
    }
}

/*
send query:
    http://localhost:9003/sb-rabbitmq/direct/producer?exchangeName=direct-exchange&routingKey=finance&messageData=Hello%20from%20rabbitMQ
    
    
    routingKey=marketing
    routingKey=finance
 */
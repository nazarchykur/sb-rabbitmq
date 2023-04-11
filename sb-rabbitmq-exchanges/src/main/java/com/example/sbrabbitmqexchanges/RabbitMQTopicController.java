package com.example.sbrabbitmqexchanges;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sb-rabbitmq/topic/")
@RequiredArgsConstructor
public class RabbitMQTopicController {

    private final AmqpTemplate amqpTemplate;

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("exchangeName") String exchange,
                           @RequestParam("routingKey") String routingKey,
                           @RequestParam("messageData") String messageData) {
        amqpTemplate.convertAndSend(exchange, routingKey, messageData);

        return "Message sent to the RabbitMQ Topic Exchange Successfully";
    }

}

/*
http://localhost:9003/sb-rabbitmq/topic/producer?exchangeName=topic-exchange&routingKey=queue3.marketing&messageData=Hello%202
 */
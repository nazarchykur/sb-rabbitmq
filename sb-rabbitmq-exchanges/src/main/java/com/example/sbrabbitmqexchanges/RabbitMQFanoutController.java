package com.example.sbrabbitmqexchanges;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sb-rabbitmq/fanout/")
@RequiredArgsConstructor
public class RabbitMQFanoutController {

    private final AmqpTemplate amqpTemplate;

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("exchangeName") String exchange,
                           @RequestParam("messageData") String messageData) {
        amqpTemplate.convertAndSend(exchange, "", messageData);

        return "Message sent to the RabbitMQ Fanout Exchange Successfully";
    }
}

/*
http://localhost:9003/sb-rabbitmq/fanout/producer?exchangeName=fanout-exchange&messageData=Hello%20from%20rabbitMQ%20fanout%20message2
 */
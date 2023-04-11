package com.example.sbrabbitmqexchanges;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQDirectConfig {

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange("direct-exchange");
    }
    
    @Bean
    Queue marketingQueue() {
        return new Queue("marketingQueue", false);
    }

    @Bean
    Queue financeQueue() {
        return new Queue("financeQueue", false);
    }
    
    @Bean
    Binding marketingBinding(Queue marketingQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(marketingQueue).to(directExchange).with("marketing");
    }
    
    @Bean
    Binding financeBinding(Queue financeQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(financeQueue).to(directExchange).with("finance");
    }
}

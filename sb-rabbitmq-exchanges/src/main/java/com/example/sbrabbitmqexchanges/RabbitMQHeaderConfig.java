package com.example.sbrabbitmqexchanges;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQHeaderConfig {

    @Bean
    Queue marketingQueue4() {
        return new Queue("marketingQueue4", false);
    }

    @Bean
    Queue financeQueue4() {
        return new Queue("financeQueue4", false);
    }

    @Bean
    HeadersExchange headerExchange() {
        return new HeadersExchange("header-exchange");
    }

    @Bean
    Binding marketingBinding4(Queue marketingQueue4, HeadersExchange headerExchange) {
        return BindingBuilder.bind(marketingQueue4).to(headerExchange).where("department").matches("marketing");
    }

    @Bean
    Binding financeBinding4(Queue financeQueue4, HeadersExchange headerExchange) {
        return BindingBuilder.bind(financeQueue4).to(headerExchange).where("department").matches("finance");
    }
}
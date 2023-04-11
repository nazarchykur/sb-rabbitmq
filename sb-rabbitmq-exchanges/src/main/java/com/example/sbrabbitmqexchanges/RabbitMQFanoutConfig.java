package com.example.sbrabbitmqexchanges;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQFanoutConfig {

    @Bean
    Queue marketingQueue2() {
        return new Queue("marketingQueue2", false);
    }

    @Bean
    Queue financeQueue2() {
        return new Queue("financeQueue2", false);
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanout-exchange");
    }

    @Bean
    Binding marketingBinding2(Queue marketingQueue2, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(marketingQueue2).to(fanoutExchange);
    }

    @Bean
    Binding financeBinding2(Queue financeQueue2, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(financeQueue2).to(fanoutExchange);
    }
}

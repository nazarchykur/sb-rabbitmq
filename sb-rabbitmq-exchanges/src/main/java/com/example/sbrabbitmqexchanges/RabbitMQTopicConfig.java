package com.example.sbrabbitmqexchanges;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQTopicConfig {

    @Bean
    Queue marketingQueue3() {
        return new Queue("marketingQueue3", false);
    }

    @Bean
    Queue financeQueue3() {
        return new Queue("financeQueue3", false);
    }

    @Bean
    Queue allQueue3() {
        return new Queue("allQueue3", false);
    }

    @Bean
    TopicExchange topicExchange3() {
        return new TopicExchange("topic-exchange");
    }

    @Bean
    Binding marketingBinding3(Queue marketingQueue3, TopicExchange topicExchange3) {
        return BindingBuilder.bind(marketingQueue3).to(topicExchange3).with("queue3.marketing");
    }

    @Bean
    Binding financeBinding3(Queue financeQueue3, TopicExchange topicExchange3) {
        return BindingBuilder.bind(financeQueue3).to(topicExchange3).with("queue3.finance");
    }

    @Bean
    Binding allBinding3(Queue allQueue3, TopicExchange topicExchange3) {
        return BindingBuilder.bind(allQueue3).to(topicExchange3).with("queue3.*");
    }

}
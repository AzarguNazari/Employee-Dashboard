package com.dashboard.useful.listener;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue bankAccounts() {
        return new Queue("queue.bankAccounts");
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("bankAccounts");
    }

    @Bean
    Binding bindingExchangeMessage(Queue bankAccounts, TopicExchange exchange) {
        return BindingBuilder.bind(bankAccounts).to(exchange).with("topic.message");
    }
}

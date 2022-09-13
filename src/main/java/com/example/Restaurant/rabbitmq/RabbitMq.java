package com.example.Restaurant.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMq {


    public static final String queue1 ="topicQueue1";
    public static final String queue2 ="topicQueue1";
    public static final String exchange ="topicExchange";

    public static final String rouingKey1 ="*.important.*";
    public static final String rouingKey2 ="#.error";





    @Bean
    public Declarables topicBindings() {

        Queue topicQueue1 = new Queue(queue1, false);
        Queue topicQueue2 = new Queue(queue2, false);



        TopicExchange topicExchange = new TopicExchange(exchange);

        return new Declarables(
                topicQueue1,
                topicQueue2,
                topicExchange,
                BindingBuilder
                        .bind(topicQueue1)
                        .to(topicExchange).with(rouingKey1),
                BindingBuilder
                        .bind(topicQueue2)
                        .to(topicExchange).with(rouingKey2));
    }
}

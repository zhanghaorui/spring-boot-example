package com.zhang.example04rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName RabbitMQConfig
 * @Author zhanghaorui
 * @Date 2021/3/10 1:39 下午
 * @Description RabbitMQConfig
 * @Version 1.0
 */
@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue helloQueue() {return new Queue("hello");}

}

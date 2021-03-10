package com.zhang.example04rabbitmq.config.util;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName HelloReceiver
 * @Author zhanghaorui
 * @Date 2021/3/10 2:01 下午
 * @Description HelloReceiver
 * @Version 1.0
 */
@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {

    @RabbitHandler
    public void receive(String s) {
        System.out.println(s);
    }
}

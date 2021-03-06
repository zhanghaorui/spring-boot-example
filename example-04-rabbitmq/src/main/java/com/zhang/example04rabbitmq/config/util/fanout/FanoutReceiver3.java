package com.zhang.example04rabbitmq.config.util.fanout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName FanoutReceiver3
 * @Author zhanghaorui
 * @Date 2021/3/10 3:07 下午
 * @Description FanoutReceiver3
 * @Version 1.0
 */
@Component
@RabbitListener(queues = "fanout.C")
public class FanoutReceiver3 {

    public static final Logger logger = LoggerFactory.getLogger(FanoutReceiver1.class);

    @RabbitHandler
    public void receive(String s) {
        logger.info("receive3"+s);
    }


}

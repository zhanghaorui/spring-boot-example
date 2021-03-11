package com.zhang.example04rabbitmq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName FanoutController
 * @Author zhanghaorui
 * @Date 2021/3/10 3:08 下午
 * @Description FanoutController
 * @Version 1.0
 */
@RestController
@RequestMapping("/fanOut")
@CrossOrigin
public class FanoutController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public static final Logger logger = LoggerFactory.getLogger(FanoutController.class);

    @PostMapping("/send")
    public String fanOutSend(@RequestBody String s) {
        logger.info(s);
        amqpTemplate.convertAndSend(s);
        return "发送成功";
    }

}

package com.zhang.example04rabbitmq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName HelloController
 * @Author zhanghaorui
 * @Date 2021/3/10 1:44 下午
 * @Description HelloController
 * @Version 1.0
 */
@RestController
@RequestMapping("/hello")
@CrossOrigin
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    @PostMapping("/sendHello")
    public String sendHello(@RequestBody  String s) {
        logger.info(s);
        amqpTemplate.convertAndSend(s);
        return "发送成功";
    }



}

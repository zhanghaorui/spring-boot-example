package com.zhang.example01aop.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@CrossOrigin
public class AOPController {

    @PostMapping("/hello")
    public String hello () {
        System.out.println("hello");
        return "hello";
    }

}

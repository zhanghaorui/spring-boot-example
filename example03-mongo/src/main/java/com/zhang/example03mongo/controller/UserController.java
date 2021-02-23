package com.zhang.example03mongo.controller;

import com.zhang.example03mongo.entity.User;
import com.zhang.example03mongo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     *  查询全部
     * @return
     */
    @PostMapping("/selectAll")
    @ResponseBody
    public List<User> selectAll() {
        return userService.selectAll();
    }


    /**
     *  条件查询
     * @param user
     * @return
     */
    @PostMapping("/selectByExample")
    @ResponseBody
    public List<User> selectByExample(User user) {
        return userService.selectByExample(user);
    }


    /**
     *  新增单条
     * @param user
     * @return
     */
    @PostMapping("/insert")
    @ResponseBody
    public int insert(User user) {
        return userService.insert(user);
    }

    /**
     *  修改单条
     */
    @PostMapping("/update")
    @ResponseBody
    public Long update(User user) {
        return userService.update(user);
    }


    /**
     *  删除单条
     */
    @PostMapping("/delete")
    @ResponseBody
    public void delete(User user) {
        userService.delete(user);
    }


}

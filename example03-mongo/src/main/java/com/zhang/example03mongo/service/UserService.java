package com.zhang.example03mongo.service;

import com.zhang.example03mongo.entity.User;

import java.util.List;

public interface UserService {
    List<User> selectAll();

    List<User> selectByExample(User user);

    int insert(User user);

    Long update(User user);

    void delete(User user);

}

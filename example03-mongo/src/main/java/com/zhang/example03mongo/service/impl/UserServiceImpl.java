package com.zhang.example03mongo.service.impl;

import com.mongodb.client.result.UpdateResult;
import com.zhang.example03mongo.entity.User;
import com.zhang.example03mongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<User> selectAll() {
        return mongoTemplate.findAll(User.class);
    }


    @Override
    public List<User> selectByExample(User user) {
        Query query = new Query().addCriteria(Criteria.where("id").is(user.getId()));
        return mongoTemplate.find(query,User.class);
    }

    @Override
    public int insert(User user) {
        User save = mongoTemplate.save(user);
        return 1;
    }

    @Override
    public Long update(User user) {
        Query query = new Query().addCriteria(Criteria.where("id").is(user.getId()));
        Update update  = new Update().set("userName",user.getUserName()).set("password",user.getPassword());
        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, User.class);
        return updateResult.getMatchedCount()==0L?0L:updateResult.getMatchedCount();
    }


    @Override
    public void delete(User user) {
        Query query = new Query().addCriteria(Criteria.where("id").is(user.getId()));
        mongoTemplate.remove(query,User.class);
    }



}

package com.zhang.example04rabbitmq.entity;

/**
 * @ClassName User
 * @Author zhanghaorui
 * @Date 2021/3/10 1:37 下午
 * @Description User
 * @Version 1.0
 */
public class User {

    private Integer id;

    private String name;

    private String password;

    private String mobile;

    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

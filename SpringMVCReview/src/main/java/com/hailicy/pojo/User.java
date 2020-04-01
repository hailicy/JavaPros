package com.hailicy.pojo;

import java.io.Serializable;

/**
 * 创建时间: 2020/3/30 19:46
 * 文件备注:username":"myname","password":"mypassowrd","age":30}',
 * 编写人员:
 */

public class User implements Serializable {

    private String username;
    private String password;
    private Integer age;

    public User(String username, String password, Integer age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}

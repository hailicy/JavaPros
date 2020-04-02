package com.hailicy.sbmbjppro.service;

import com.hailicy.sbmbjppro.entity.User;

/**
 * 创建时间: 2020/4/1 21:50
 * 文件备注:
 * 编写人员:
 */

public interface UserService {

    void saveUser(User user);

    //登录
    User login(String username,String password);
}

package com.hailicy.sbmbjppro.service;

import com.hailicy.sbmbjppro.dao.UserDao;
import com.hailicy.sbmbjppro.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * 创建时间: 2020/4/1 21:51
 * 文件备注:
 * 编写人员:
 */

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public void saveUser(User user) {
        user.setId(UUID.randomUUID().toString());
        userDao.save(user);
    }

    @Override
    public User login(String username, String password) {
        return userDao.findByUsernameAndPassword(username,password);
    }


}

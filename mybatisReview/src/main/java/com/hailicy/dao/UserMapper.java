package com.hailicy.dao;

import com.hailicy.pojo.User;
import com.hailicy.pojo.blob;

import java.util.List;
import java.util.Map;

/**
 * 创建时间: 2020/2/12 20:56
 * 文件备注:
 * 编写人员:
 */

public interface UserMapper {
    //查询全部用户
    List<User> getUserList();

    //根据ID查询用户
    User getUserById(int id);

    //插入用户
    int insertUser(User user);

    //修改用户
    int updateUser(User user);

    //删除一个用户
    int deleteUser(int id);

    //实现分页查询
    List<User> getUser(Map<String,Integer> map);

    //动态sql学习
    List<User> queryUser(Map<String ,Object> map);

    //动态sql学习，choose
    List<User> queryUser2(Map<String ,Object> map);

    //动态sql学习，where
    List<User> queryUser3(Map<String ,Object> map);

    //动态修改用户
    int updateUser2(Map<String ,Object> map);

    //插入textblob
    void insertBlob(blob blob);
}

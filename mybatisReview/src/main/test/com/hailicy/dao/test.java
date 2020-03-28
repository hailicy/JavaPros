package com.hailicy.dao;

import com.hailicy.pojo.User;
import com.hailicy.utils.mybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 创建时间: 2020/3/28 17:33
 * 文件备注:
 * 编写人员:
 */

public class test {
    static Logger logger = Logger.getLogger(test.class);

    @Test//遍历
    public void test1(){
        SqlSession sqlSession = mybatisUtils.getSqlSessionFactory();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List userList = userMapper.getUserList();
        System.out.println(userList);


    }

    @Test
    public void test2(){
        SqlSession sqlSession = mybatisUtils.getSqlSessionFactory();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Integer> map = new HashMap<String ,Integer>();
        map.put("startIndex",0);
        map.put("pageSize",2);
        System.out.println();
        List<User> userList = userMapper.getUser(map);
        for (User user : userList) {
            System.out.println(user);
        }
    }
}

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

    @Test//分页查询
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

    @Test//按id删除
    public void test3(){
        SqlSession sqlSession = mybatisUtils.getSqlSessionFactory();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUser(1);
    }

    @Test//获取list
    public void test4(){
        SqlSession sqlSession = mybatisUtils.getSqlSessionFactory();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
    }


    @Test//按id查找
    public void test5(){
        SqlSession sqlSession = mybatisUtils.getSqlSessionFactory();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        try {
            User user = userMapper.getUserById(4);
            if(user!=null){
            System.out.println(user);}else {
                System.out.println("未找到！");
            }
        }catch (Exception e){e.printStackTrace();}
        finally {
            sqlSession.commit();
        }
    }

    @Test//插入
    public void test6() {
        SqlSession sqlSession = mybatisUtils.getSqlSessionFactory();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        try {
            int i = userMapper.insertUser(new User(null, "插入的内容", "插入的密码"));
            System.out.println("插入的数量为" + i);
            sqlSession.commit();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.commit();
        }
    }

    @Test//按id修改
    public void test7(){
        SqlSession sqlSession = mybatisUtils.getSqlSessionFactory();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        try {

            userMapper.updateUser(new User(1, "改后的内容", "改后的密码"));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.commit();
            System.out.println("修改执行成功！");
        }
    }
}

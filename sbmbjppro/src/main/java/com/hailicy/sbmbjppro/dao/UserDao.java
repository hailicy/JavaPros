package com.hailicy.sbmbjppro.dao;

import com.hailicy.sbmbjppro.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 创建时间: 2020/4/1 19:50
 * 文件备注:
 * 编写人员:
 */

public interface UserDao {

    //保存用户测试方法
    void save(User user);

    //查找用户
    User findByUsernameAndPassword(@Param("username")String username, @Param("password") String password);


}

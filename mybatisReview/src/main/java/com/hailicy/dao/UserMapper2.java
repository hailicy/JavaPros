package com.hailicy.dao;

import com.hailicy.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 创建时间: 2020/4/1 17:26
 * 文件备注:
 * 编写人员:
 */

public interface UserMapper2 {

    @Select("select * from user")
    List<User> getAll();
}

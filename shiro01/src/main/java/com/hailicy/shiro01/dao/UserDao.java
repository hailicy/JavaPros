package com.hailicy.shiro01.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hailicy.shiro01.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


/**
 * 创建时间: 2020/5/3 14:04
 * 文件备注:
 * 编写人员: 杨伯益
 */

@Repository
@Mapper
public interface UserDao extends BaseMapper<User> {

    @Select("select * from User where username=#{username}")
    User getUser(@Param("username")String username);
}

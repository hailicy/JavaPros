package com.hailicy.dao;

//接口

import com.hailicy.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository//交给容器管理
public interface AccountDao {


    //查询所有账户
    @Select("select * from ssm.account")
    public List<Account> findAll();

    //保存账户信息
    @Insert("insert into account(name,money,age) values(#{name}, #{money}, #{age})")
    public void saveAccount(Account account);

}

package com.hailicy.service.impl;

import com.hailicy.dao.AccountDao;
import com.hailicy.domain.Account;
import com.hailicy.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 创建时间: 2020/3/13 19:46
 * 文件备注:
 * 编写人员:
 */

@Service("accountService")//交给容器管理
public class AccountServiceImpl implements AccountService {

    @Autowired//注入
    private AccountDao accountDao;

    public List<Account> findAll() {
        System.out.println("业务层，查询所有的账户信息！");
        return accountDao.findAll();
    }

    public void saveAccount(Account account) {
        System.out.println("业务层，保存账户！");
        accountDao.saveAccount(account);
    }
}

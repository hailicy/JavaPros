package com.hailicy.controller;

import com.hailicy.domain.Account;
import com.hailicy.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 创建时间: 2020/3/13 19:47
 * 文件备注:账户web控制器
 * 编写人员:
 */

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired//spring注入
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("表现层：查询所有的账户信息！");
        //调用service的方法
        List<Account> list = accountService.findAll();
        model.addAttribute("list",list);
        return "list";
    }

    @RequestMapping("/save")//保存之后重定向到查询页面
    public void save(Account account, HttpServletResponse response, HttpServletRequest request) throws Exception {
        System.out.println("表现层：插入的账户信息！");
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
        return;
    }


}

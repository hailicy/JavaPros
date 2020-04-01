package com.hailicy.springboottest02.controller;

import com.hailicy.springboottest02.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 创建时间: 2020/3/28 15:25
 * 文件备注:
 * 编写人员:
 */


@Controller
public class UserController {

    @GetMapping("/hello")
    public String hello(Model model){
        User user = new User();
        user.setAge(66);
        user.setName("杨伯益");
        model.addAttribute("user",user);
        return "hello2";
    }
}

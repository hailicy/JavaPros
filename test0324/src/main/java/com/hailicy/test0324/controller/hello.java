package com.hailicy.test0324.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建时间: 2020/3/24 21:29
 * 文件备注:
 * 编写人员:
 */


@RestController
@RequestMapping("/hello")
public class hello {

    @GetMapping("/hello")
    @RequestMapping("/hello")
    public String hello(){



        return "hello,world2!";
    }
}

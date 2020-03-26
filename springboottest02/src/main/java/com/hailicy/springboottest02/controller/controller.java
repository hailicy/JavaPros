package com.hailicy.springboottest02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建时间: 2020/3/26 9:34
 * 文件备注:
 * 编写人员:
 */


@RestController
public class controller {

    @GetMapping("/hello")
    public String hello(){



        return "hello";
    }
}

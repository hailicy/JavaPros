package com.hailicy.springboottest02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 创建时间: 2020/3/28 14:50
 * 文件备注:
 * 编写人员:
 */

//需要themylf解析器
@Controller
public class IdnexController {


    @RequestMapping("/index")
    public String index(){

        return "index";
    }
}

package com.hailicy.sbmbjppro.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建时间: 2020/4/1 18:50
 * 文件备注:
 * 编写人员:
 */

@RestController
@RequestMapping("/test")
public class testController {

    @RequestMapping("/test")
    public String test(){
        System.out.println("test method invoke!");
        return "test成功";
    }
}

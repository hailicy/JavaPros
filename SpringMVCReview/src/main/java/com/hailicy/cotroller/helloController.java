package com.hailicy.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class helloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}

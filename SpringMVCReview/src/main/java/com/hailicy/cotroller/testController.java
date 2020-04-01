package com.hailicy.cotroller;

import com.hailicy.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 创建时间: 2020/3/30 11:32
 * 文件备注:
 * 编写人员:
 */

@RequestMapping("/test")
@Controller
public class testController {

    @RequestMapping("/get")
    public String getParams(HttpServletRequest req, HttpServletResponse resp){
        String name = req.getParameter("name");
        Integer age = Integer.valueOf(req.getParameter("age"));
        System.out.println(name+":"+age);
        return "success";
    }

    @RequestMapping("/bangding")
    public String up(String username,int age){
        System.out.println(username);
        System.out.println(age);


        return "success";
    }

    @RequestMapping("/json")
    public String js(){
        System.out.println("跳过去");
        return "js";
    }


    @RequestMapping("/testajax")
    public @ResponseBody User ajax(@RequestBody User user){
        System.out.println("过来");
        System.out.println(user);
        return user;
    }

    @RequestMapping("/testforward")
    public String testforward(){
        return "forward:/WEB-INF/pages/success.jsp";
    }

    @RequestMapping("/testredirect")
    public String testredirect(){
        return "redirect:/index.jsp";
    }
}

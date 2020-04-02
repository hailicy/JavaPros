package com.hailicy.sbmbjppro.controller;

import com.hailicy.sbmbjppro.entity.User;
import com.hailicy.sbmbjppro.service.UserService;
import com.hailicy.sbmbjppro.utils.ValidateImageCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 创建时间: 2020/4/1 21:28
 * 文件备注:
 * 编写人员:
 */


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("getImage")
    public void getImage(HttpSession session, HttpServletResponse response)throws IOException {
        //生成验证码
        String securityCode = ValidateImageCodeUtils.getSecurityCode();
        //将验证码放入session
        session.setAttribute("code",securityCode);
        //生成图片
        BufferedImage image = ValidateImageCodeUtils.createImage(securityCode);
        //输出图片，通过响应方式输出
        ServletOutputStream outputStream = response.getOutputStream();
        //调用工具类
        ImageIO.write(image,"png",outputStream);
    }

    @PostMapping("/regist")
    public String regist(User user,HttpSession session,String code){
        //首先判断验证码是否通过
        if(session.getAttribute("code").toString().equalsIgnoreCase(code)) {
            //注册
            userService.saveUser(user);
            return "redirect:/ems/login.jsp";
        }else {//未通过
            return "redirect:/ems/regist.jsp";
        }
    }

    //登录
    @RequestMapping("/login")
    public String login(String username,String password,HttpSession session){
        User user = userService.login(username,password);
        //若为空则不存在用户
        if(user!=null){
            session.setAttribute("user",user);
            return "redirect:/ems/emplist.jsp";
        }else{//不存在
            return "redirect:/ems/login.jsp";
        }
    }
}

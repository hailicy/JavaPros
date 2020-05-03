package com.system.controller;

import com.system.po.Userlogin;
import com.system.service.UserloginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class RegistController {

    @Resource(name = "userloginServiceImpl")
    private UserloginService userloginService;

   @RequestMapping(value = "/doRegist")
    public String doRegist(Userlogin userlogin, Model model){
       System.out.println(userlogin.getUsername());
       userloginService.regist(userlogin);
       return "registsuccess";
   }

   @RequestMapping(value = "/wxuserdoRegist",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Map<String,Object> wxuserdoRegist(Userlogin userlogin) throws Exception{
       Map<String,Object> map = new HashMap<String, Object>();
       userloginService.regist(userlogin);
       map.put("userdoRegist","true");
       return map;
   }
}

package com.hailicy.shiro01.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.catalina.User;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.ShiroFilter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 创建时间: 2020/5/3 12:47
 * 文件备注:
 * 编写人员: 杨伯益
 */

@Configuration
public class shiroConfig {


    //第三步、创建工厂
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        //添加shiro的内置过滤器
        /*
            anno无需认证就可以访问
            authc必须认证才访问
            user拥有记住我功能才会用
            perms拥有对某个资源的权限才能访问
            role拥有某个角色权限才能访问
         */

        //登录认证
        Map<String,String> filterMap = new LinkedHashMap<>();
//        filterMap.put("/user/add","authc");
//        filterMap.put("/user/update","authc");

        //授权，正常的情况下未授权会跳转到未授权页面，否则401
        filterMap.put("/user/add","perms[user:add]");//user需要有add权限才能访问
        filterMap.put("/user/update","perms[user:update]");//user需要有add权限才能访问

        filterMap.put("/user/*","authc");


        bean.setFilterChainDefinitionMap(filterMap);

        //设置登录的请求
        bean.setLoginUrl("/toLogin");

        //设置未授权的请求
        bean.setUnauthorizedUrl("/noauth");

        return bean;
    }



    //第二步、创建securitymanager                                  与userrealm绑起来
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联realme
        securityManager.setRealm(userRealm);


        return securityManager;
    }


    //第一步、创建realm对象，需要自定义类
    @Bean(name = "userRealm")
    public UserRealm userRealm(){
        return new UserRealm();
    }


    //整合thymeleaf
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }



}

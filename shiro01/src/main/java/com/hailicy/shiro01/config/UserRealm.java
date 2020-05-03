package com.hailicy.shiro01.config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

/**
 * 创建时间: 2020/5/3 12:49
 * 文件备注:
 * 编写人员: 杨伯益
 */


public class UserRealm extends AuthorizingRealm {

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权！");
        return null;
    }


    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行认证！");
        //模拟数据库取数据
        String username="123";
        String password="456";

        UsernamePasswordToken userToken = (UsernamePasswordToken)token;
        if(!userToken.getUsername().equals(username)){//如果用户名不一致
            return null;//会抛出用户名不存在异常
        }

        //密码认证，shiro来做
        return new SimpleAuthenticationInfo("",password,"");

    }
}

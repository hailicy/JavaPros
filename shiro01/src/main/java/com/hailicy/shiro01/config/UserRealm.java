package com.hailicy.shiro01.config;

import com.hailicy.shiro01.dao.UserDao;
import com.hailicy.shiro01.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 创建时间: 2020/5/3 12:49
 * 文件备注:
 * 编写人员: 杨伯益
 */


public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserDao userDao;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权！");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //首先拿到当前登录对象
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();

        //从数据库拿，然后设置权限
        info.addStringPermission(currentUser.getPerms());


        return info;
    }


    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行认证！");


        UsernamePasswordToken userToken = (UsernamePasswordToken)token;
        if(userDao.getUser(userToken.getUsername())==null){//如果用户名不一致
            return null;//会抛出用户名不存在异常
        }

        //密码认证，shiro来做
        return new SimpleAuthenticationInfo(userDao.getUser(userToken.getUsername()),userDao.getUser(userToken.getUsername()).getPassword(),"");

    }
}

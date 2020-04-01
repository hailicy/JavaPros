package com.hailicy.utils;

import com.hailicy.dao.UserMapper2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 创建时间: 2020/3/28 17:32
 * 文件备注:
 * 编写人员:
 */

public class utils {
    private static SqlSessionFactory sqlSessionFactory;

    static{
        try {
            //获取SqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = null;
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSessionFactory.getConfiguration().addMapper(UserMapper2.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSessionFactory(){
        return sqlSessionFactory.openSession();
    }
}

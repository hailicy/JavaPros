package com.hailicy.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 创建时间: 2020/3/22 19:26
 * 文件备注:
 * 编写人员:
 */

public class reflectDemo {

    public static void main(String[] args) throws Exception{
        //Class clz = Class.forName("com.hailicy.reflect.Person");
        Class clz = Person.class;


        Method method1 = clz.getMethod("setAge", int.class);
        Method method2 = clz.getMethod("toString");
        //Constructor constructor = clz.getConstructor();
        //Object object = constructor.newInstance();
        Object object = clz.newInstance();
        method1.invoke(object,87);
        System.out.println(method2.invoke(object));

    }

}

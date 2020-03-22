package com.hailicy.test;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 创建时间: 2020/3/22 16:23
 * 文件备注:
 * 编写人员:
 */

public class VectorDemo {

    public static void main(String[] args) {

        Vector v = new Vector();

        v.add("1");
        v.add("2");
        v.add("3");
        v.add("4");

        Enumeration en = v.elements();//枚举和迭代器很相似

        while (en.hasMoreElements()){
            System.out.println(en.nextElement());
        }

    }
}

package com.hailicy.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建时间: 2020/3/22 16:04
 * 文件备注:
 * 编写人员:
 */

public class ListDemo {

    public static void main(String[] args) {
        ArrayList al = new ArrayList();

        al.add("next1");
        al.add("next2");
        al.add("next3");
        al.add("next4");
        al.add("next5");



        al.add(2,"第二个插入");
        al.remove(2);
        System.out.println(al);


        List sub = al.subList(1,3);
        System.out.println(sub);

    }

}

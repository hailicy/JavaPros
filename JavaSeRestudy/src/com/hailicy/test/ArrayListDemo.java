package com.hailicy.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 创建时间: 2020/3/22 11:07
 * 文件备注:
 * 编写人员:
 */

public class ArrayListDemo {

    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        al.add("next1");
        al.add("next2");
        al.add("next3");
        al.add("next4");
        al.add("next5");

        Iterator it = al.iterator();

        //System.out.println(it.next());

        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
}

package com.hailicy.test;

import java.util.HashSet;
import java.util.Iterator;

/**
 * 创建时间: 2020/3/22 16:35
 * 文件备注:
 * 编写人员:
 */

public class HashSetDemo {

    public static void main(String[] args) {

        HashSet hs = new HashSet();
        hs.add("1");
        hs.add("2");
        hs.add("3");
        hs.add("4");

        Iterator it = hs.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

    }
}

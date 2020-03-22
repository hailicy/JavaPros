package com.hailicy.test;

import java.awt.event.ItemEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 创建时间: 2020/3/22 17:00
 * 文件备注:
 * 编写人员:
 */

public class MapDemo {

    public static void main(String[] args) {
        Map<Integer,Person> map = new HashMap<Integer, Person>();


        map.put(1,new Person(30,"大刘"));
        map.put(2,new Person(301,"大刘1"));


    }
}

class Person{
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

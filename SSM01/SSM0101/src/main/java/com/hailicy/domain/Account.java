package com.hailicy.domain;

import java.io.Serializable;

/**
 * 创建时间: 2020/3/13 19:41
 * 文件备注:账户信息
 * 编写人员:
 */

public class Account implements Serializable {

    private Integer id;
    private String name;
    private Double money;
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", age=" + age +
                '}';
    }
}

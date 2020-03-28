package com.hailicy.pojo;

//import jdk.internal.org.jline.utils.StyleResolver;

import org.springframework.stereotype.Component;

/**
 * 创建时间: 2020/3/28 22:23
 * 文件备注:
 * 编写人员:
 */


@Component
public class Addr {

    private String addr;

    public Addr(String addr) {
        this.addr = addr;
    }

    public Addr() {
    }

    @Override
    public String toString() {
        return "Addr{" +
                "addr='" + addr + '\'' +
                '}';
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}

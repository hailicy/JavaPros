package com.hailicy.pojo;

import java.util.Arrays;

/**
 * 创建时间: 2020/4/3 15:56
 * 文件备注:
 * 编写人员:
 */

public class blob {

    private Integer id;
    private byte[] text;

    @Override
    public String toString() {
        return "blob{" +
                "id=" + id +
                ", text=" + Arrays.toString(text) +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getText() {
        return text;
    }

    public void setText(byte[] text) {
        this.text = text;
    }

    public blob() {
    }

    public blob(Integer id, byte[] text) {
        this.id = id;
        this.text = text;
    }
}

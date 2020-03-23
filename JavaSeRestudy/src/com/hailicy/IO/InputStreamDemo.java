package com.hailicy.IO;

import java.io.FileOutputStream;

/**
 * 创建时间: 2020/3/23 15:52
 * 文件备注:
 * 编写人员:
 */

public class InputStreamDemo {

    public static void main(String[] args) throws Exception{

        //通过字节流读取图片文件
        FileOutputStream fos = new FileOutputStream("D://demo20200323.txt",true);
        fos.write("字节流的".getBytes());
    }
}

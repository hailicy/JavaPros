package com.hailicy.IO;

import java.io.FileReader;
import java.io.IOException;

/**
 * 创建时间: 2020/3/23 15:17
 * 文件备注:
 * 编写人员:
 */

public class readerDemo {

    public static void main(String[] args) throws IOException {

        //要保证文件存在否则抛异常
        FileReader fileReader = new FileReader("D:/demo20200323.txt");


        int num = 0;
        char buf[]=new char[3];
        while ((num = fileReader.read(buf))!=-1){
            System.out.print(new String(buf,0,num));
        }
    }

}

package com.hailicy.IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * 创建时间: 2020/3/23 15:44
 * 文件备注:
 * 编写人员:
 */

public class BufferReaderDemo {

    public static void main(String[] args) throws Exception{

        FileReader fileWriter = new FileReader("D:/demo20200323.txt");
        //提高效率
        BufferedReader bufferedReader = new BufferedReader(fileWriter);
        //读取一行的功能
        //System.out.println(bufferedReader.readLine());

        //完整读取
        String line = null;
        while ((line=bufferedReader.readLine())!=null){
            System.out.println(line);
        }


    }
}


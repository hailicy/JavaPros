package com.hailicy.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * 创建时间: 2020/3/23 15:36
 * 文件备注:
 * 编写人员:
 */

public class BufferWriter {

    public static void main(String[] args) throws Exception{

        //缓冲区的目的是提高流的操作效率
        //创建缓冲区之前必须先有流对象
        FileWriter fileWriter = new FileWriter("D:/demo20200323.txt",true);
        //将需要提高效率的流对象作为参数传递给缓冲区的构造函数即可
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.newLine();
        bufferedWriter.write("换行之后缓冲来的");
        //用到缓冲区就要记得刷新
        bufferedWriter.flush();
        //要关闭缓冲区的流
        bufferedWriter.close();


    }
}

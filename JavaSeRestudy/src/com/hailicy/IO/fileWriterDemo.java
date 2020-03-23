package com.hailicy.IO;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 创建时间: 2020/3/23 14:57
 * 文件备注:
 * 编写人员:
 */

public class fileWriterDemo {

    public static void main(String[] args) throws IOException {
        //首先创建对象
        //被初始化之后就要有被操作的文件

        //文件会被创建到指定位置
        //如果已经存在同名文件，将会被覆盖

        //true参数表示在末尾续写而不是覆盖
        FileWriter fileWriter = new FileWriter("D:/demo20200323.txt",true);

        fileWriter.write("增加");

        fileWriter.write("换行前\r\n后");


        //关闭之前会刷新缓冲区
        fileWriter.close();
    }
}

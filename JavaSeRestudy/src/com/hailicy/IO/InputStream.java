package com.hailicy.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 创建时间: 2020/3/23 15:57
 * 文件备注:
 * 编写人员:
 */

public class InputStream {

    public static void main(String[] args) throws Exception{

        FileOutputStream fos = new FileOutputStream("");
        FileInputStream fis = new FileInputStream("");
        byte[] buf = new byte[1024];
        int len = 0;
        while((len=fis.read(buf))!=-1){
            fos.write(buf,0,len);
        }
        fis.close();
        fos.close();
    }
}

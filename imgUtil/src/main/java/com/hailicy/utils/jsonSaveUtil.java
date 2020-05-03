package com.hailicy.utils;

import java.io.*;

/**
 * 创建时间: 2020/4/20 16:07
 * 文件备注:
 * 编写人员:
 */


public class jsonSaveUtil {


    public static void saveDataToFile(String fileName,String data) {
        BufferedWriter writer = null;
        File file = new File(fileName);
        //如果文件不存在，则新建一个
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //写入
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,false), "UTF-8"));
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(writer != null){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("文件写入成功！");
    }
}

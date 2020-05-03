package com.hailicy.utils;

import org.junit.Test;

import java.io.*;

/**
 * 创建时间: 2020/4/20 20:44
 * 文件备注:
 * 编写人员:
 */


public class mergeUtil {

    public static StringBuilder merge(int i)throws Exception {

        String Path = "D:\\notes\\json\\河南";
        BufferedReader reader = null;
        String laststr = "";
        try {
            //int i = 0, j = 0;
            FileInputStream fileInputStream = new FileInputStream(Path + "\\" +i+ ".json");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                laststr += tempString;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        StringBuilder sb = new StringBuilder(laststr);
        if(sb.length()<5) {
            System.out.println("抓到你！");
            return null;
        }
        sb.replace(0,1,"");
        sb.replace(sb.length()-1,sb.length(),"");
        return sb;
    }


    public static void main(String[] args) throws Exception{
        StringBuilder temp = null;
        StringBuilder sb = new StringBuilder("[");

            for (int j=1;j<=2109;j++){
                temp=merge(j);
                if(temp!=null){
                    System.out.println("不是null"+j);
                    System.out.println(j+"是"+temp);
                    sb.append(temp);
                    sb.append(",");
                }
                System.out.println("在"+j);
            }

        sb.append("]");
        //去掉最后一个逗号
        sb.replace(sb.length()-2,sb.length()-1,"");

        //写入到文件
        File file = new File("D:\\notes\\河南.json");
        FileWriter fw = new FileWriter(file);
        fw.write(sb.toString());


        fw.close();
    }


}

package com.hailicy.utils;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 创建时间: 2020/4/19 19:54
 * 文件备注:
 * 编写人员:
 */


public class imgUtil {




    // 地址
    public static final String URL = "https://www.amap.com/detail/B001B0JKWG?citycode=420100";
    // 获取img标签正则
    public static final String IMGURL_REG = "<img.*src=(.*?)[^>]*?>";
    // 获取src路径的正则
    public static final String IMGSRC_REG = "[a-zA-z]+://[^\\s]*";




    public static String utilMain(String url)throws Exception{

        imgUtil cm=new imgUtil();
        //获得html文本内容
        String HTML = cm.getHtml(url);
        //获取图片标签
        List<String> imgUrl = cm.getImageUrl(HTML);
        //获取图片src地址
        List<String> imgSrc = cm.getImageSrc(imgUrl);
        System.out.println(imgSrc);

        if(imgSrc!=null) {
            System.out.println(imgSrc.get(0));
        }else {
            System.out.println("未找到！");
        }

        return imgSrc.get(0);
    }





    //获取HTML内容
    public static String getHtml(String url)throws Exception{
        URL url1=new URL(url);//使用java.net.URL
        URLConnection connection=url1.openConnection();//打开链接
        InputStream in=connection.getInputStream();//获取输入流
        InputStreamReader isr=new InputStreamReader(in);//流的包装
        BufferedReader br=new BufferedReader(isr);

        String line;
        StringBuffer sb=new StringBuffer();
        while((line=br.readLine())!=null){//整行读取
            sb.append(line,0,line.length());//添加到StringBuffer中
            sb.append('\n');//添加换行符
        }
        //关闭各种流，先声明的后关闭
        br.close();
        isr.close();
        in.close();
        return sb.toString();
    }

    //获取ImageUrl地址
    public List<String> getImageUrl(String html){
        Matcher matcher= Pattern.compile(IMGURL_REG).matcher(html);
        List<String>listimgurl=new ArrayList<String>();
        while (matcher.find()){
            listimgurl.add(matcher.group());
        }
        return listimgurl;
    }


    //获取ImageSrc地址
    public List<String> getImageSrc(List<String> listimageurl){
        List<String> listImageSrc=new ArrayList<String>();
        for (String image:listimageurl){
            Matcher matcher=Pattern.compile(IMGSRC_REG).matcher(image);
            while (matcher.find()){
                listImageSrc.add(matcher.group().substring(0, matcher.group().length()-1));
            }
        }
        return listImageSrc;
    }

    @Test
    public void test() throws Exception {
        String url = "https://www.amap.com/detail/B0FFFGLNA6";
        imgUtil cm=new imgUtil();
        //获得html文本内容
        String HTML = cm.getHtml(url);
        //获取图片标签
        List<String> imgUrl = cm.getImageUrl(HTML);
        //获取图片src地址
        List<String> imgSrc = cm.getImageSrc(imgUrl);


        System.out.println(imgSrc.get(0));

    }

}

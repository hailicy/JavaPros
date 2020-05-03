package com.hailicy;

import com.hailicy.utils.imgUtil;

import java.util.List;

/**
 * 创建时间: 2020/4/19 19:55
 * 文件备注:
 * 编写人员:
 */


public class Main {

    static String url = "https://www.amap.com/detail/B0FFFGLNA6";

    public static void main(String[] args) throws Exception{



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
    }
}

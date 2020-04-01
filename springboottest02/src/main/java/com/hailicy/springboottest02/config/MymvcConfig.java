package com.hailicy.springboottest02.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 创建时间: 2020/3/30 21:12
 * 文件备注:
 * 编写人员:
 */


@Configuration
public class MymvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/atoo").setViewName("success.html");
    }
}

package com.hailicy.sbmbjppro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.hailicy.sbmbjppro.dao")
//@ComponentScan("com.hailicy.sbmbjppro.service")
public class SbmbjpproApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SbmbjpproApplication.class);
    }


    public static void main(String[] args) {
        SpringApplication.run(SbmbjpproApplication.class, args);
    }
}

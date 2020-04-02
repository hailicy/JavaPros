package com.hailicy.sbmbjppro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.hailicy.sbmbjppro.dao")
//@ComponentScan("com.hailicy.sbmbjppro.service")
public class SbmbjpproApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbmbjpproApplication.class, args);
    }

}

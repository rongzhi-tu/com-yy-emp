package com.yy.emp.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by tuz
 * on 2020/5/15.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.yy.emp.web","com.yy.emp.service"})
@MapperScan(basePackages = "com.yy.emp.dao")
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class,args);
    }
}

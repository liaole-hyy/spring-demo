package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.example")
public class DemoApplication {

    public static void main(String[] args) {
        System.out.println("------spring本身启动");
        SpringApplication.run(DemoApplication.class, args);
    }

}

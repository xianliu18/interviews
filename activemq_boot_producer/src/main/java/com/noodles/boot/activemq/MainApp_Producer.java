package com.noodles.boot.activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Description: 主启动类
 * @Author: noodles
 * @create: 2021-03-21 19:29
 */
@SpringBootApplication
@EnableScheduling
public class MainApp_Producer {
    public static void main(String[] args) {
        SpringApplication.run(MainApp_Producer.class);
    }
}

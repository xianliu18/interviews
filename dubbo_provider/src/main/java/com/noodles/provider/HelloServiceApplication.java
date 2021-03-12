package com.noodles.provider;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName HelloServiceApplication
 * @Description 主启动类
 * @Author noodles
 * @Date 2021/3/12 15:50
 */
@EnableDubbo
@SpringBootApplication
public class HelloServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloServiceApplication.class, args);
    }
}

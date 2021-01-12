package com.noodles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @ClassName CustomApplication
 * @Description 主启动类
 * @Author noodles
 * @Date 2021/1/12 15:36
 */
@SpringBootApplication
public class CustomApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(CustomApplication.class, args);
    }
}

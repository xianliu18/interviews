package com.noodles;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName ConsumerApplication
 * @Description 主启动类
 *      1, 导入 dubbo-starter, 在 application.properties 设置属性
 *      2, 使用 @Service 暴露服务, 使用 @Reference 引用服务
 *      3, @EnableDubbo 开启基于注解的 dubbo 功能
 * @Author noodles
 * @Date 2021/3/12 16:05
 */
@EnableDubbo
@SpringBootApplication
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}

package com.noodles.aop.test;

import com.noodles.aop.CalcService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @ClassName TestAop
 * @Description 切面测试类
 * @Author noodles
 * @Date 2021/1/12 15:31
 */
@SpringBootTest
public class TestAop {

    @Resource
    private CalcService calcService;

    @Test
    public void testAop5() {
        System.out.println("Spring 版本: " + SpringVersion.getVersion() + "\t springboot 版本： " + SpringBootVersion.getVersion());
        calcService.div(10, 2);
    }

}

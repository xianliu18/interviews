package com.noodles.spi;

import com.noodles.spi.myinterface.Robot;
import org.junit.Test;

import java.util.ServiceLoader;

/**
 * @ClassName JavaSPITest
 * @Description Java SPI 测试
 * @Author noodles
 * @Date 2021/3/12 9:01
 */
public class JavaSPITest {
    @Test
    public void sayHello() {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(Robot::sayHello);
    }
}

package com.noodles.spi;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.noodles.spi.myinterface.Robot;
import org.junit.Test;

/**
 * @ClassName DubboSPITest
 * @Description dubbo SPI 测试
 * 参考链接：www.tianxiaobo.com/categories/java-framework/dubbo/
 * @Author noodles
 * @Date 2021/3/12 9:05
 */
public class DubboSPITest {

    @Test
    public void sayHello() {
        ExtensionLoader<Robot> extensionLoader = ExtensionLoader.getExtensionLoader(Robot.class);
        Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
        optimusPrime.sayHello();
        Robot bumblebee = extensionLoader.getExtension("bumblebee");
        bumblebee.sayHello();
    }
}

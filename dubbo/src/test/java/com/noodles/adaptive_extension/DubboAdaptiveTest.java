package com.noodles.adaptive_extension;

import com.alibaba.dubbo.common.URL;
import org.junit.Test;

/**
 * @ClassName DubboAdaptiveTest
 * @Description 自适应拓展测试
 * @Author noodles
 * @Date 2021/3/12 10:57
 */
public class DubboAdaptiveTest {
    @Test
    public void adaptiveTest() {
        // dubbo://127.0.0.1:8015/CarService?wheel.maker=MichelinWheelMaker
        URL url = new URL("dubbo", "127.0.0.1", 8015, "CarService", "Wheel.maker", "michelinWheelMaker");
        RaceCarMaker carMaker = new RaceCarMaker();
        carMaker.setWheelMaker(new AdaptiveWheelMaker());
        carMaker.makeCar(url);
    }
}

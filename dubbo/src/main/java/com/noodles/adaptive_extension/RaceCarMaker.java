package com.noodles.adaptive_extension;

import com.alibaba.dubbo.common.URL;
import com.noodles.adaptive_extension.domain.Car;
import com.noodles.adaptive_extension.domain.RaceCar;
import com.noodles.adaptive_extension.domain.Wheel;
import com.noodles.adaptive_extension.minterface.WheelMaker;

/**
 * @ClassName RaceCarMaker
 * @Description
 * @Author noodles
 * @Date 2021/3/12 10:49
 */
public class RaceCarMaker {

    WheelMaker wheelMaker;

    // 通过 setter 注入 AdaptiveWheelMaker
    public void setWheelMaker(WheelMaker wheelMaker) {
        this.wheelMaker = wheelMaker;
    }

    public Car makeCar(URL url) {
        Wheel wheel = wheelMaker.makeWheel(url);
        System.out.println(wheel.getMaker());
        return new RaceCar(wheel);
    }
}

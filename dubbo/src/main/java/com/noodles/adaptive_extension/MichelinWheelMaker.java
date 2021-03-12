package com.noodles.adaptive_extension;

import com.alibaba.dubbo.common.URL;
import com.noodles.adaptive_extension.domain.Wheel;
import com.noodles.adaptive_extension.minterface.WheelMaker;

/**
 * @ClassName MichelinWheelMaker
 * @Description 具体的轮胎制造厂
 * @Author noodles
 * @Date 2021/3/12 11:19
 */
public class MichelinWheelMaker implements WheelMaker {
    @Override
    public Wheel makeWheel(URL url) {
        System.out.println("制造了一个Dubbo牌轮胎");
        return new Wheel("dubbo");
    }
}

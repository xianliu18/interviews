package com.noodles.adaptive_extension.minterface;

import com.alibaba.dubbo.common.URL;
import com.noodles.adaptive_extension.domain.Car;

/**
 * @Author noodles
 * @Description 汽车制造厂
 * @Date 2021/3/12 10:02
 */
public interface CarMaker {
    Car makeCar(URL url);
}

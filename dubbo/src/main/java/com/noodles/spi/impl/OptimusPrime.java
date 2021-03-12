package com.noodles.spi.impl;

import com.noodles.spi.myinterface.Robot;

/**
 * @ClassName OptimusPrime
 * @Description 实现类（擎天柱）
 * @Author noodles
 * @Date 2021/3/12 8:58
 */
public class OptimusPrime implements Robot {
    @Override
    public void sayHello() {
        System.out.println("Hello, I am Optimus Prime.");
    }
}

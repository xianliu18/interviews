package com.noodles.spi.impl;

import com.noodles.spi.myinterface.Robot;

/**
 * @ClassName BumbleBee
 * @Description 实现类（大黄蜂）
 * @Author noodles
 * @Date 2021/3/12 8:58
 */
public class BumbleBee implements Robot {
    @Override
    public void sayHello() {
        System.out.println("Hello, I am Bumblebee.");
    }
}

package com.noodles.adaptive_extension.domain;

/**
 * @ClassName Car
 * @Description 汽车实体
 * @Author noodles
 * @Date 2021/3/12 10:48
 */
public class Car {

    private Wheel wheel;

    public Car(Wheel wheel) {
        this.wheel = wheel;
    }

    public Wheel getWheel() {
        return wheel;
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }
}

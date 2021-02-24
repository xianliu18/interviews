package com.noodles.design_pattern.strategy;

/**
 * @ClassName AirStragety
 * @Description 坐飞机出行
 * @Author noodles
 * @Date 2021/2/24 11:54
 */
public class AirStrategy implements TravelStrategy {
    @Override
    public void travelWay() {
        System.out.println("坐飞机");
    }

    @Override
    public boolean isOK(int type) {
        if (type <= 2000 && type > 500) {
            return true;
        }
        return false;
    }
}

package com.noodles.design_pattern.strategy;

/**
 * @ClassName TrainStrategy
 * @Description 坐火车出行
 * @Author noodles
 * @Date 2021/2/24 11:56
 */
public class TrainStrategy implements TravelStrategy {
    @Override
    public void travelWay() {
        System.out.println("坐火车");
    }

    @Override
    public boolean isOK(int type) {
        if (type >= 20 && type < 400) {
            return true;
        }
        return false;
    }
}

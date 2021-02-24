package com.noodles.design_pattern.strategy;

/**
 * @ClassName BicycleStragety
 * @Description 骑自行车出行
 * @Author noodles
 * @Date 2021/2/24 11:55
 */
public class BicycleStrategy implements TravelStrategy {
    @Override
    public void travelWay() {
        System.out.println("自行车");
    }

    @Override
    public boolean isOK(int type) {
        if (type <= 20) {
            return true;
        }
        return false;
    }
}

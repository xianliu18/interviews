package com.noodles.design_pattern.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PersonContext
 * @Description 策略模式环境类
 * @Author noodles
 * @Date 2021/2/24 11:57
 */
public class PersonContext {

    // 策略类集合
    private List<TravelStrategy> strategyList;

    public PersonContext() {
        this.strategyList = new ArrayList<>();
        strategyList.add(new AirStrategy());
        strategyList.add(new TrainStrategy());
        strategyList.add(new BicycleStrategy());
    }

    public void travel(int type) {
        for (TravelStrategy strategy : strategyList) {
            if (strategy.isOK(type)) {
                strategy.travelWay();
                break;
            }
        }
    }
}

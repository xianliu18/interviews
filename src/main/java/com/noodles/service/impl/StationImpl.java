package com.noodles.service.impl;

import com.noodles.service.Station;

/**
 * @ClassName StationImpl
 * @Description 实现类
 * @Author noodles
 * @Date 2021/1/18 21:03
 */
public class StationImpl implements Station {
    @Override
    public void sellTickets() {
        System.out.println("售票");
    }

    @Override
    public void ticketChange() {
        System.out.println("改签");
    }
}

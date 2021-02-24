package com.noodles.design_pattern.strategy;

/**
 * @Author noodles
 * @Description 策略类
 * 参考链接： https://juejin.cn/post/6844904017772937229
 * @Date 2021/2/24 11:53
 */
public interface TravelStrategy {

    void travelWay();

    boolean isOK(int type);

}

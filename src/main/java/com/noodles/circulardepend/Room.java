package com.noodles.circulardepend;

/**
 * @ClassName Room
 * @Description 测试用例
 * @Author noodles
 * 参考链接： www.tianxiaobo.com/2018/06/08/Spring-IOC-容器源码分析-循环依赖的解决办法/
 * @Date 2021/2/20 15:37
 */
public class Room {

    private String television;
    private String airConditioner;
    private String refrigerator;
    private String washer;

    public String getTelevision() {
        return television;
    }

    public void setTelevision(String television) {
        this.television = television;
    }

    public String getAirConditioner() {
        return airConditioner;
    }

    public void setAirConditioner(String airConditioner) {
        this.airConditioner = airConditioner;
    }

    public String getRefrigerator() {
        return refrigerator;
    }

    public void setRefrigerator(String refrigerator) {
        this.refrigerator = refrigerator;
    }

    public String getWasher() {
        return washer;
    }

    public void setWasher(String washer) {
        this.washer = washer;
    }
}

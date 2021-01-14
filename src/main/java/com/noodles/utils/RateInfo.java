package com.noodles.utils;

/**
 * @ClassName RateInfo
 * @Description 计算比例的实体
 * @Author noodles
 * @Date 2021/1/14 17:22
 */
public class RateInfo {

    // 最大hash
    private int maxHash;
    // 最小hash
    private int minHash;
    // hash 计算乘积因子
    private int multiplier;
    // 碰撞数
    private int collisionCount;
    // 碰撞比率
    private double collisionRate;


    public RateInfo(int maxHash, int minHash, int multiplier, int collisionCount, double collisionRate) {
        this.maxHash = maxHash;
        this.minHash = minHash;
        this.multiplier = multiplier;
        this.collisionCount = collisionCount;
        this.collisionRate = collisionRate;
    }

    public int getMaxHash() {
        return maxHash;
    }

    public void setMaxHash(int maxHash) {
        this.maxHash = maxHash;
    }

    public int getMinHash() {
        return minHash;
    }

    public void setMinHash(int minHash) {
        this.minHash = minHash;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getCollisionCount() {
        return collisionCount;
    }

    public void setCollisionCount(int collisionCount) {
        this.collisionCount = collisionCount;
    }

    public double getCollisionRate() {
        return collisionRate;
    }

    public void setCollisionRate(double collisionRate) {
        this.collisionRate = collisionRate;
    }
}

package com.noodles.concurrent.bean;

/**
 * @Description: 减库存
 *      参考链接: https://www.bilibili.com/video/BV1VE411q7dX?p=36
 * @Author: noodles
 * @create: 2021-05-13 16:37
 */
public class Stock {

    // 库存数量
    private static int num = 1;

    // 减少库存数量
    public boolean reduceStock() {
        if (num > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num--;
            return true;
        } else {
            return false;
        }
    }
}

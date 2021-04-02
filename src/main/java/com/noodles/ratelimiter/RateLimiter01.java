package com.noodles.ratelimiter;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @ClassName RateLimiter01
 * @Description RateLimiter 示例
 *      参考链接：https://mp.weixin.qq.com/s/37WkBzmGb4Fevbk4HQEISw
 * @Author noodles
 * @Date 2021/4/2 18:19
 */
public class RateLimiter01 {
    public static void main(String[] args) {
        // QPS = 5
        RateLimiter rateLimiter = RateLimiter.create(5);
        for (int i = 0; i < 10; i++) {
            rateLimiter.acquire();
            System.out.println(System.currentTimeMillis());
        }
        System.out.println("----------");
        // 调整速率为 qps = 10
        rateLimiter.setRate(10);
        for (int i = 0; i < 10; i++) {
            rateLimiter.acquire();
            System.out.println(System.currentTimeMillis());
        }
    }
}

package com.noodles.redis.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName GoodController
 * @Description 控制层
 * @Author noodles
 * @Date 2021/1/13 10:22
 */
@RestController
public class GoodController {

    public static final String REDIS_LOCK = "noodles";

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/buyGoods")
    public String buyGoods() {

        String value = UUID.randomUUID().toString() + Thread.currentThread().getName();

        try {

            Boolean flag = stringRedisTemplate.opsForValue().setIfAbsent(REDIS_LOCK, value, 10L, TimeUnit.SECONDS);

            if (!flag) {
                return "抢锁失败！！";
            }

            String result = stringRedisTemplate.opsForValue().get("goods:001");
            int goodsNumber = result == null ? 0 : Integer.parseInt(result);
            if (goodsNumber > 0) {
                int realNumber = goodsNumber - 1;
                stringRedisTemplate.opsForValue().set("goods:001", String.valueOf(realNumber));
                String resp = "成功买到商品，库存还剩下： " + realNumber + " 件 <br> 服务提供端口为：" + serverPort;
                System.out.println(resp);
                return resp;
            } else {
                String failResp = "商品已售完，欢迎下次光临~~" + serverPort;
                System.out.println(failResp);
                return failResp;
            }
        } finally {
            if (stringRedisTemplate.opsForValue().get(REDIS_LOCK).equalsIgnoreCase(value)) {
                stringRedisTemplate.delete(REDIS_LOCK);
            }
        }
    }
}

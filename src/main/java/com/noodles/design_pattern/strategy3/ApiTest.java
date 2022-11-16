package com.noodles.design_pattern.strategy3;

import com.noodles.design_pattern.strategy3.event.ZKCouponDiscount;
import java.math.BigDecimal;
import org.junit.Test;

/**
 * @description: 测试
 * @author: liuxian
 * @date: 2022-11-16 18:21
 */
public class ApiTest {
    @Test
    public void test_zk() {
        // 折扣 9 折， 商品 100 元
        Context<Double> context = new Context<>(new ZKCouponDiscount());
        BigDecimal discountAmount = context.discountAmount(0.9D, new BigDecimal(100));
        System.out.println("测试结果：" + discountAmount);
    }
}

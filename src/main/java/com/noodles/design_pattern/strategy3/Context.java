package com.noodles.design_pattern.strategy3;

import java.math.BigDecimal;

/**
 * @description: 策略控制类
 * @author: liuxian
 * @date: 2022-11-16 18:11
 */
public class Context<T> {

    private ICouponDiscount<T> couponDiscount;

    public Context(ICouponDiscount<T> couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public BigDecimal discountAmount(T couponInfo, BigDecimal skuPrice) {
        return couponDiscount.discountAmount(couponInfo, skuPrice);
    }
}

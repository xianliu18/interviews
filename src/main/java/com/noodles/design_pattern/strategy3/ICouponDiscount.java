package com.noodles.design_pattern.strategy3;

import java.math.BigDecimal;

/**
 * @description: 优惠券接口
 * @author: liuxian
 * @date: 2022-11-16 18:12
 */
public interface ICouponDiscount<T> {
    
    /**
     * 优惠券金额计算
     */
    BigDecimal discountAmount(T couponInfo, BigDecimal skuPrice);
    
}

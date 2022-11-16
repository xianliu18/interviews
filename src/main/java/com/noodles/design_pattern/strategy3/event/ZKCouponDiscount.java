package com.noodles.design_pattern.strategy3.event;

import com.noodles.design_pattern.strategy3.ICouponDiscount;
import java.math.BigDecimal;

/**
 * @description: 折扣
 * @author: liuxian
 * @date: 2022-11-16 18:12
 */
public class ZKCouponDiscount implements ICouponDiscount<Double> {

    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        BigDecimal discountAmount = skuPrice.multiply(new BigDecimal(couponInfo).setScale(2, BigDecimal.ROUND_HALF_UP));
        if (discountAmount.compareTo(BigDecimal.ZERO) < 1) {
            return BigDecimal.ONE;
        }
        return discountAmount;
    }
}

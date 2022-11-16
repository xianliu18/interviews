package com.noodles.design_pattern.strategy3.event;

import com.noodles.design_pattern.strategy3.ICouponDiscount;
import java.math.BigDecimal;

/**
 * @description: 直减计算
 * @author: liuxian
 * @date: 2022-11-16 18:12
 */
public class ZJCouponDiscount implements ICouponDiscount<Double> {

    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(couponInfo));
        if (discountAmount.compareTo(BigDecimal.ZERO) < 1) {
            return BigDecimal.ONE;
        }
        return discountAmount;
    }

}

package com.noodles.design_pattern.strategy3.event;

import com.noodles.design_pattern.strategy3.ICouponDiscount;
import java.math.BigDecimal;

/**
 * @description: N 元购
 * @author: liuxian
 * @date: 2022-11-16 18:12
 */
public class NYGCouponDiscount implements ICouponDiscount<Double> {

    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        return new BigDecimal(couponInfo);
    }
}

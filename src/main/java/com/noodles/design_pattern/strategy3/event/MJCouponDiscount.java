package com.noodles.design_pattern.strategy3.event;

import com.noodles.design_pattern.strategy3.ICouponDiscount;
import java.math.BigDecimal;
import java.util.Map;

/**
 * @description: 满减优惠计算
 * @author: liuxian
 * @date: 2022-11-16 18:12
 */
public class MJCouponDiscount implements ICouponDiscount<Map<String, String>> {

    @Override
    public BigDecimal discountAmount(Map<String, String> couponInfo, BigDecimal skuPrice) {
        String x = couponInfo.get("x");
        String o = couponInfo.get("n");

        if (skuPrice.compareTo(new BigDecimal(x)) < 0) {
            return skuPrice;
        }
        BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(o));
        if (discountAmount.compareTo(BigDecimal.ZERO) < 1) {
            return BigDecimal.ONE;
        }
        return discountAmount;
    }
}

package com.noodles.design_pattern.strategy3.draft;

/**
 * @description: 使用策略模式之前
 *              参考链接：https://bugstack.cn/md/develop/design-pattern/2020-07-05-重学%20Java%20设计模式《实战策略模式》.html
 * @author: liuxian
 * @date: 2022-11-16 18:04
 */
public class CouponDiscountService {
    /**
     * 优惠券折扣计算接口：
     *     1，直减券
     *     2，满减券
     *     3，折扣券
     *     4，N 元购
     */
    public double discountAmount(int type, double typeContent, double skuPrice, double typeExt) {
        // 1, 直减券
        if (1 == type) {
            return skuPrice - typeContent;
        }
        // 2, 满减券
        if (2 == type) {
            if (skuPrice < typeExt) {
                return skuPrice;
            }
            return skuPrice - typeContent;
        }
        // 3, 折扣券
        if (3 == type) {
            return skuPrice * typeContent;
        }
        // 4, N 元购
        if (4 == type) {
            return typeContent;
        }
        return 0d;
    }
}

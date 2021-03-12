package com.noodles.adaptive_extension.minterface;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.SPI;
import com.noodles.adaptive_extension.domain.Wheel;

/**
 * @Author noodles
 * @Description 车轮制造厂
 * @Date 2021/3/12 10:02
 */
@SPI
public interface WheelMaker {
    Wheel makeWheel(URL url);
}

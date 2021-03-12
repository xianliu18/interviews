package com.noodles.adaptive_extension;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.noodles.adaptive_extension.domain.Wheel;
import com.noodles.adaptive_extension.minterface.WheelMaker;

/**
 * @ClassName AdaptiveWheelMaker
 * @Description 实现类
 * @Author noodles
 * @Date 2021/3/12 10:43
 */
public class AdaptiveWheelMaker implements WheelMaker {

    @Override
    public Wheel makeWheel(URL url) {
        if (url == null) {
            throw new IllegalStateException("url == null");
        }

        // 1, 从 URL 中获取 WheelMaker 名称
        String wheelMakerName = url.getParameter("Wheel.maker");
        if (wheelMakerName == null) {
            throw new IllegalStateException("wheelMakerName == null");
        }

        // 2, 通过 SPI 加载具体的 WheelMaker
        WheelMaker wheelMaker = ExtensionLoader.getExtensionLoader(WheelMaker.class).getExtension(wheelMakerName);

        // 3, 调用目标方法
        return wheelMaker.makeWheel(url);
    }
}

package com.noodles.aop.impl;

import com.noodles.aop.CalcService;
import org.springframework.stereotype.Service;

/**
 * @ClassName CalcServiceImpl
 * @Description 实现类
 * @Author noodles
 * @Date 2021/1/12 15:11
 */
@Service
public class CalcServiceImpl implements CalcService {
    @Override
    public int div(int x, int y) {
        int result = x / y;
        System.out.println("==========>CalcServiceImpl被调用类，计算结果：" + result);
        return result;
    }
}

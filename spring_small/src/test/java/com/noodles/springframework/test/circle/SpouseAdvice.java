package com.noodles.springframework.test.circle;

import com.noodles.springframework.aop.MethodBeforeAdvice;
import java.lang.reflect.Method;

/**
 * @description: SpouseAdvice
 * @author: liuxian
 * @date: 2022-11-14 16:02
 */
public class SpouseAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] obejcts, Object target) throws Throwable {
        System.out.println("关怀小两口（切面）：" + method);
    }

}

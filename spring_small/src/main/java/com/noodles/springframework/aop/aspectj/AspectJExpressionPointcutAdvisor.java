package com.noodles.springframework.aop.aspectj;

import com.noodles.springframework.aop.Pointcut;
import com.noodles.springframework.aop.PointcutAdvisor;
import org.aopalliance.aop.Advice;

/**
 * @description: AspectJExpressionPointcutAdvisor
 * @author: liuxian
 * @date: 2022-11-13 16:55
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    // 切面
    private AspectJExpressionPointcut pointcut;
    // 具体的拦截方法
    private Advice advice;
    // 表达式
    private String expression;

    public void setExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public Pointcut getPointcut() {
        if (null == pointcut) {
            pointcut = new AspectJExpressionPointcut(expression);
        }
        return pointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }
}

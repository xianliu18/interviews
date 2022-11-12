package com.noodles.springframework.beans;

/**
 * @description: 定义 Bean 异常
 * @author: liuxian
 * @date: 2022-11-11 15:45
 */
public class BeansException extends RuntimeException {

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}

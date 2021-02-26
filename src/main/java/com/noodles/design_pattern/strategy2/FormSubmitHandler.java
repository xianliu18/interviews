package com.noodles.design_pattern.strategy2;

import java.io.Serializable;

/***
 * @Author noodles
 * @Description 定义策略的接口: 表单提交处理器
 * 参考链接： https://my.oschina.net/u/4662964/blog/4723828
 * @Date 2021/2/26 11:15
 */
public interface FormSubmitHandler<R extends Serializable> {

    /**
     * @Author noodles
     * @Description 获取策略类型的方法： 获得提交类型
     * @Date 2021/2/26 11:16
     * @Param []
     * @return java.lang.String
     */
    String getSubmitType();

    /**
     * @Author noodles
     * @Description 处理策略逻辑的方法：  处理表单提交请求
     * @Date 2021/2/26 11:27
     * @Param [request]
     * @return com.noodles.design_pattern.strategy2.CommonPairResponse<java.lang.String>
     */
    CommonPairResponse<String> handleSubmit(FormSubmitRequest request);
}

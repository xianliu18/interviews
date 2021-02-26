package com.noodles.design_pattern.strategy2.impl;

import com.noodles.design_pattern.strategy2.CommonPairResponse;
import com.noodles.design_pattern.strategy2.FormSubmitHandler;
import com.noodles.design_pattern.strategy2.FormSubmitRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.lang.invoke.SerializedLambda;

/**
 * @ClassName FormPreviewSubmitHandler
 * @Description 策略实现类： 预览表单时的提交
 * @Author noodles
 * @Date 2021/2/26 11:29
 */
public class FormPreviewSubmitHandler implements FormSubmitHandler<Serializable> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String getSubmitType() {
        return "preview";
    }

    @Override
    public CommonPairResponse<String> handleSubmit(FormSubmitRequest request) {
        logger.info("预览模式提交： userId = {}, formInput = {}", request.getUserId(), request.getFormInput());
        return CommonPairResponse.success(200, "预览模式提交数据成功!");
    }
}

package com.noodles.design_pattern.strategy2.impl;

import com.noodles.design_pattern.strategy2.CommonPairResponse;
import com.noodles.design_pattern.strategy2.FormSubmitHandler;
import com.noodles.design_pattern.strategy2.FormSubmitRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * @ClassName FormHsfSubmitHandler
 * @Description HSF 模式提交
 * @Author noodles
 * @Date 2021/2/26 11:35
 */
public class FormHsfSubmitHandler implements FormSubmitHandler<Serializable> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String getSubmitType() {
        return "hsf";
    }

    @Override
    public CommonPairResponse<String> handleSubmit(FormSubmitRequest request) {
        logger.info("HSF 模式提交：userId = {}, formInput = {}", request.getUserId(), request.getFormInput());
        
        CommonPairResponse<String> response = hsfSubmitData(request);
        return response;
    }

    private CommonPairResponse<String> hsfSubmitData(FormSubmitRequest request) {
        return CommonPairResponse.success(200, "HSF 模式提交成功!");
    }
}

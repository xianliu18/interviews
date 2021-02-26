package com.noodles.design_pattern.strategy2.impl;

import com.noodles.design_pattern.strategy2.CommonPairResponse;
import com.noodles.design_pattern.strategy2.FormSubmitHandler;
import com.noodles.design_pattern.strategy2.FormSubmitHandlerFactory;
import com.noodles.design_pattern.strategy2.FormSubmitRequest;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * @ClassName FormServiceImpl
 * @Description service 层
 * @Author noodles
 * @Date 2021/2/26 13:49
 */
public class FormServiceImpl {

    @Autowired
    private FormSubmitHandlerFactory submitHandlerFactory;

    public CommonPairResponse submitForm(@NonNull FormSubmitRequest request) {

        String submitType = request.getSubmitType();

        // 根据 submitType 找到对应的提交处理器
        FormSubmitHandler<Serializable> submitHandler = submitHandlerFactory.getHandler(submitType);

        // 判断submitType 对应的handler是否存在
        if (submitHandler == null) {
            return CommonPairResponse.failed(500, "非法的提交类型: " + submitType);
        }

        return submitHandler.handleSubmit(request);
    }
}

package com.noodles.design_pattern.strategy2.impl;

import com.noodles.design_pattern.strategy2.CommonPairResponse;
import com.noodles.design_pattern.strategy2.FormSubmitHandler;
import com.noodles.design_pattern.strategy2.FormSubmitRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName FormModelSubmitHandler
 * @Description 策略类实现： 模型输入时提交
 * @Author noodles
 * @Date 2021/2/26 11:32
 */
public class FormModelSubmitHandler implements FormSubmitHandler<Long> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String getSubmitType() {
        return "model";
    }

    @Override
    public CommonPairResponse<String> handleSubmit(FormSubmitRequest request) {

        logger.info("模型提交： userId = {}, formInput = {}", request.getUserId(), request.getFormInput());

        // 模型创建成功后，获取模型的 id
        Long modelId = createModel(request);

        return CommonPairResponse.success(200, "模型提交成功！");
    }

    private Long createModel(FormSubmitRequest request) {
        return 123L;
    }
}

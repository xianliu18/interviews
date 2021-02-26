package com.noodles.design_pattern.strategy2;

import lombok.Data;

import java.util.Map;

/**
 * @ClassName FormSubmitRequest
 * @Description 表单提交的请求
 * @Author noodles
 * @Date 2021/2/26 11:25
 */
@Data
public class FormSubmitRequest {
    
    /**
     * 提交类型
     */
    private String submitType;

    /**
     * 用户 id
     */
    private Long userId;

    /**
     * 表单提交的值
     */
    private Map<String, Object> formInput;
}

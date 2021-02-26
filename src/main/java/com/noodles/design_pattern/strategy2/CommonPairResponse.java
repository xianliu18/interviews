package com.noodles.design_pattern.strategy2;

import java.io.Serializable;

/**
 * @ClassName CommonPairResponse
 * @Description 公共响应类
 * @Author noodles
 * @Date 2021/2/26 11:19
 */
public class CommonPairResponse<T> implements Serializable {

    private static final long serialVersionUID = -6384654624756721226L;

    private Integer code;
    private String message;

    private CommonPairResponse(Integer code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public static <T> CommonPairResponse<T> success(Integer code, String message) {
        return new CommonPairResponse<>(code, message);
    }

    public static <T> CommonPairResponse<T> failed(Integer code, String message) {
        return new CommonPairResponse<>(code, message);
    }
}

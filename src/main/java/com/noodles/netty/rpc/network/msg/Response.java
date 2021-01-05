package com.noodles.netty.rpc.network.msg;

/**
 * @ClassName Response
 * @Description 响应消息
 * @Author noodles
 * @Date 2021/1/5 10:35
 */
public class Response {

    private String requestId;
    private String param;


    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}

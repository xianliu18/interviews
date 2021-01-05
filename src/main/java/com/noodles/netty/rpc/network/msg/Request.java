package com.noodles.netty.rpc.network.msg;

/**
 * @ClassName Request
 * @Description 请求信息
 * @Author noodles
 * @Date 2021/1/5 10:35
 */
public class Request {

    private String requestId;
    private Object result;


    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}

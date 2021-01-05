package com.noodles.netty.rpc.newrpc.network.msg;

import io.netty.channel.Channel;

/**
 * @ClassName Response
 * @Description 响应类
 * @Author noodles
 * @Date 2021/1/5 15:28
 */
public class Response {

    private transient Channel channel;
    private String requestId;
    private Object result;

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

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

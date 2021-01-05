package com.noodles.netty.rpc.newrpc.network.future;

import com.noodles.netty.rpc.newrpc.network.msg.Response;

import java.util.concurrent.Future;

/**
 * @ClassName WriteFuture
 * @Description 接口writefuture
 * @Author noodles
 * @Date 2021/1/5 15:36
 */
public interface WriteFuture<T> extends Future<T> {

    Throwable cause();

    void setCause(Throwable cause);

    boolean isWriteSuccess();

    void setWriteResult(boolean result);

    String requestId();

    T response();

    void setResponse(Response response);

    boolean isTimeout();
}

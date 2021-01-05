package com.noodles.netty.rpc.network.future;

import com.noodles.netty.rpc.network.msg.Response;

import java.util.concurrent.Future;

/**
 * @ClassName WriteFuture
 * @Description future类
 * @Author noodles
 * @Date 2021/1/5 10:35
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

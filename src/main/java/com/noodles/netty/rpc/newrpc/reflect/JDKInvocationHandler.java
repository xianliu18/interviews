package com.noodles.netty.rpc.newrpc.reflect;

import com.noodles.netty.rpc.newrpc.network.future.SyncWrite;
import com.noodles.netty.rpc.newrpc.network.msg.Request;
import com.noodles.netty.rpc.newrpc.network.msg.Response;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName JDKInvocationHandler
 * @Description 自定义 JDK 处理器
 * @Author noodles
 * @Date 2021/1/5 17:14
 */
public class JDKInvocationHandler implements InvocationHandler {

    private Request request;

    public JDKInvocationHandler(Request request) {
        this.request = request;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        Class[] paramTypes = method.getParameterTypes();
        if ("toString".equals(methodName) && paramTypes.length == 0) {
            return request.toString();
        } else if ("hashCode".equals(methodName) && paramTypes.length == 0) {
            return request.hashCode();
        } else if ("equals".equals(methodName) && paramTypes.length == 1) {
            return request.equals(args[0]);
        }

        // 设置参数
        request.setMethodName(methodName);
        request.setParamTypes(paramTypes);
        request.setArgs(args);
        request.setRef(request.getRef());
        Response response = new SyncWrite().writeAndSync(request.getChannel(), request, 5000);
        // 异步调用
        return response.getResult();
    }
}

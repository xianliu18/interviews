package com.noodles.netty.rpc.network.client;

import com.noodles.netty.rpc.network.future.SyncWriteFuture;
import com.noodles.netty.rpc.network.future.SyncWriteMap;
import com.noodles.netty.rpc.network.msg.Response;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @ClassName MyClientHandler
 * @Description 自定义客户端处理器
 * @Author noodles
 * @Date 2021/1/5 10:34
 */
public class MyClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        Response message = (Response)msg;
        String requestId = message.getRequestId();
        SyncWriteFuture future = (SyncWriteFuture) SyncWriteMap.syncKey.get(requestId);
        if (future != null) {
            future.setResponse(message);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}

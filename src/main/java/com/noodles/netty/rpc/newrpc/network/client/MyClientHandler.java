package com.noodles.netty.rpc.newrpc.network.client;

import com.noodles.netty.rpc.network.future.SyncWriteMap;
import com.noodles.netty.rpc.newrpc.network.future.SyncWriteFuture;
import com.noodles.netty.rpc.newrpc.network.msg.Response;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @ClassName MyClientHandler
 * @Description 自定义客户端处理器
 * @Author noodles
 * @Date 2021/1/5 15:26
 */
public class MyClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object obj) throws Exception {
        Response msg = (Response)obj;
        String requestId = msg.getRequestId();
        SyncWriteFuture future = (SyncWriteFuture) SyncWriteMap.syncKey.get(requestId);
        if (future != null) {
            future.setResponse(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}

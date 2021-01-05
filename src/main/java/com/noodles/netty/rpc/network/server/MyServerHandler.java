package com.noodles.netty.rpc.network.server;

import com.noodles.netty.rpc.network.msg.Request;
import com.noodles.netty.rpc.network.msg.Response;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * @ClassName MyServerHandler
 * @Description 服务器端处理器
 * @Author noodles
 * @Date 2021/1/5 10:35
 */
public class MyServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object obj) {
        Request msg = (Request)obj;
        // 反馈
        Response resp = new Response();
        resp.setRequestId(msg.getRequestId());
        resp.setParam(msg.getResult() + "请求成功， 反馈结果，请接受处理。");
        ctx.writeAndFlush(resp);
        // 释放
        ReferenceCountUtil.release(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }
}

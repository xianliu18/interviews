package com.noodles.netty.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.CharsetUtil;

import java.net.URI;

/**
 * @ClassName HttpServerHandler
 * @Description 自定义Handler类
 * @Author noodles
 * @Date 2020/12/31 11:48
 */
public class HttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {

    // 读取客户端数据
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        if (msg instanceof HttpRequest) {

            System.out.println("pipeline hashcode" + ctx.pipeline().hashCode() + ", HttpServerHandler hash=" + this.hashCode());

            System.out.println("msg 类型为：" + msg.getClass());
            System.out.println("客户端地址为：" + ctx.channel().remoteAddress());

            HttpRequest httpRequest = (HttpRequest)msg;
            // 获取到 uri
            URI uri = new URI(httpRequest.uri());
            if ("/favicon.ico".equals(uri.getPath())) {
                System.out.println("请求了 favicon.ico, 不做响应");
                return;
            }

            // 响应客户端请求，需要按http协议组装
            ByteBuf content = Unpooled.copiedBuffer("Response from netty server", CharsetUtil.UTF_8);

            // 构造httpResponse
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);

            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());

            ctx.writeAndFlush(response);
        }
    }
}

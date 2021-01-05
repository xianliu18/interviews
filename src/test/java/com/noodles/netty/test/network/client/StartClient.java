package com.noodles.netty.test.network.client;

import com.alibaba.fastjson.JSON;
import com.noodles.netty.rpc.network.client.ClientSocket;
import com.noodles.netty.rpc.network.future.SyncWrite;
import com.noodles.netty.rpc.network.msg.Request;
import com.noodles.netty.rpc.network.msg.Response;
import io.netty.channel.ChannelFuture;

/**
 * @ClassName StartClient
 * @Description 客户端测试类
 * @Author noodles
 * @Date 2021/1/5 10:37
 */
public class StartClient {

    private static ChannelFuture future;

    public static void main(String[] args) {
        ClientSocket client = new ClientSocket();
        new Thread(client).start();

        while(true) {
            try {
                // 获取future，线程有等待处理时间
                if (null == future) {
                    future = client.getFuture();
                    Thread.sleep(500);
                    continue;
                }
                // 构建发送参数
                Request request = new Request();
                request.setResult("查询用户信息");
                SyncWrite s = new SyncWrite();
                Response resp = s.writeAndAsync(future.channel(), request, 1000);
                System.out.println("调用结果：" + JSON.toJSON(resp));
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

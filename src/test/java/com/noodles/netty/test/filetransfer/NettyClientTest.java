package com.noodles.netty.test.filetransfer;

import com.noodles.netty.filetransfer.client.NettyClient;
import com.noodles.netty.filetransfer.domain.FileTransferProtocol;
import com.noodles.netty.filetransfer.util.MsgUtil;
import io.netty.channel.ChannelFuture;

import java.io.File;

/**
 * @ClassName NettyClient
 * @Description 客户端
 * @Author noodles
 * @Date 2021/3/10 9:15
 */
public class NettyClientTest {
    public static void main(String[] args) {
        ChannelFuture channelFuture = new NettyClient().connect("127.0.0.1", 8015);

        // 文件需要大于 1024KB 方便测试断点续传
        File file = new File("C:\\Users\\zhangsan\\Desktop\\mysql操作手册.pdf");
        FileTransferProtocol transferProtocol = MsgUtil.buildRequestTransferFile(file.getAbsolutePath(), file.getName(), file.length());

        // 开始传输文件
        channelFuture.channel().writeAndFlush(transferProtocol);
    }
}

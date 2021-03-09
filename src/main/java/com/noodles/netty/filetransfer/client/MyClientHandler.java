package com.noodles.netty.filetransfer.client;

import com.noodles.netty.filetransfer.domain.Constants;
import com.noodles.netty.filetransfer.domain.FileBurstData;
import com.noodles.netty.filetransfer.domain.FileBurstInstruct;
import com.noodles.netty.filetransfer.domain.FileTransferProtocol;
import com.noodles.netty.filetransfer.util.FileUtil;
import com.noodles.netty.filetransfer.util.MsgUtil;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.SocketChannel;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: 自定义处理器
 * @Author: noodles
 * @create: 2021-03-09 22:07
 */
public class MyClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        SocketChannel channel = (SocketChannel)ctx.channel();
        System.out.println("链接报告信息: 客户端链接到服务器, channelId: " + channel.id());
        System.out.println("IP地址为: " + channel.localAddress().getHostString());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("断开链接: " + ctx.channel().localAddress().toString());
        super.channelInactive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 数据格式验证
        if (!(msg instanceof FileTransferProtocol)) {
            return;
        }

        FileTransferProtocol protocol = (FileTransferProtocol)msg;
        // 0 传输文件请求  1 文件传输指令  2 文件传输数据
        switch (protocol.getTransferType()) {
            case 1:
                FileBurstInstruct instruct = (FileBurstInstruct)protocol.getTransferObj();
                if (Constants.FileStatus.COMPLETE == instruct.getStatus()) {
                    ctx.flush();
                    ctx.close();
                    System.exit(-1);
                    return;
                }
                FileBurstData burstData = FileUtil.readFile(instruct.getClientFileUrl(), instruct.getReadPosition());
                ctx.writeAndFlush(MsgUtil.buildTransferData(burstData));
                System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "传输文件, " +
                                "文件信息为, FILE: " + burstData.getFileName() + " SIZE(byte): " + (burstData.getEndPos() - burstData.getBeginPos()));
                break;
            default:
                break;
        }

        // 以下代码为模拟传输过程中断
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "客户端传输文件信息[主动断开链接, 模拟断点续传]");
//        ctx.flush();
//        ctx.close();
//        System.exit(-1);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
        System.out.println("异常信息: \r\n" + cause.getMessage());
    }
}

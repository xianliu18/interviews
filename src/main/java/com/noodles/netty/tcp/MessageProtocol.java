package com.noodles.netty.tcp;

import lombok.Data;

/**
 * @ClassName MessageProtocol
 * @Description 消息类
 * @Author noodles
 * @Date 2021/1/1 15:19
 */
@Data
public class MessageProtocol {
    private int len;
    private byte[] content;

}

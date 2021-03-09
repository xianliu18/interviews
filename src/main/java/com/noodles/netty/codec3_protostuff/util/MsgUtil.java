package com.noodles.netty.codec3_protostuff.util;

import com.noodles.netty.codec3_protostuff.domain.MsgInfo;

/**
 * @ClassName MsgUtil
 * @Description 工具类
 * @Author noodles
 * @Date 2021/3/9 15:59
 */
public class MsgUtil {

    public static MsgInfo buildMsg(String channelId, String msgContent) {
        return new MsgInfo(channelId, msgContent);
    }
    
}

package com.noodles.netty.filetransfer.util;

import com.noodles.netty.filetransfer.domain.FileBurstInstruct;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description:
 * @Author: noodles
 * @create: 2021-03-09 22:09
 */
public class CacheUtil {

    public static Map<String, FileBurstInstruct> burstDataMap = new ConcurrentHashMap<>();

}

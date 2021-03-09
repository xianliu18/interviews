package com.noodles.netty.filetransfer.domain;

/**
 * @Description: 常量类
 * @Author: noodles
 * @create: 2021-03-09 22:08
 */
public class Constants {

    public static class FileStatus {
        public static int BEGIN = 0;    // 开始
        public static int CENTER = 1;    // 中间
        public static int END = 2;    // 结尾
        public static int COMPLETE = 3;    // 完成
    }


    public static class TransferType {
        public static int REQUEST = 0;    // 0 请求传输文件
        public static int INSTRUCT = 1;    // 1 文件传输指令
        public static int DATA = 2;    // 2 文件传输数据
    }
}

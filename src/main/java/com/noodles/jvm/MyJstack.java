package com.noodles.jvm;


import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;
import java.io.InputStream;
import sun.tools.attach.HotSpotVirtualMachine;

/**
 * @Description: Jstack 工作原理
 *      参考连接: https://www.cnblogs.com/qingquanzi/p/8974850.html
 * @Author: noodles
 * @create: 2021-04-21 17:46
 */
public class MyJstack {
    public static void main(String[] args) throws IOException, AttachNotSupportedException {
        VirtualMachine virtualMachine = VirtualMachine.attach("59739");
        HotSpotVirtualMachine spotMachine = (HotSpotVirtualMachine)virtualMachine;
        InputStream inputStream = spotMachine.remoteDataDump(new String[]{});

        byte[] buff = new byte[256];
        int len;
        do {
            len = inputStream.read(buff);
            if (len > 0) {
                String response = new String(buff, 0, len, "UTF-8");
                System.out.println(response);
            }
        } while (len > 0);

        inputStream.close();
        virtualMachine.detach();
    }
}

package com.noodles.bio.client;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * @ClassName BioClient
 * @Description Bio 客户端
 * @Author noodles
 * @Date 2021/1/4 18:25
 */
public class BioClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8015);
        System.out.println("Bio client start done");
        BioClientHandler bioClientHandler = new BioClientHandler(socket, Charset.forName("utf-8"));
        bioClientHandler.start();
    }
}

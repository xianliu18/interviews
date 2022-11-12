package com.noodles.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @description: 远程文件资源
 * @author: liuxian
 * @date: 2022-11-11 18:25
 */
public class UrlResource implements Resource {

    private final URL url;

    public UrlResource(URL url) {
        if (url == null) {
            throw new NullPointerException("URL must not be null");
        }
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection con = this.url.openConnection();
        try {
            return con.getInputStream();
        } catch (IOException e) {
            if (con instanceof HttpURLConnection) {
                ((HttpURLConnection)con).disconnect();
            }
            throw e;
        }
    }
}

package com.noodles.springframework.core.io;

import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.lang3.StringUtils;

/**
 * @description: 默认的资源加载类
 * @author: liuxian
 * @date: 2022-11-11 18:24
 */
public class DefaultResourceLoader implements ResourceLoader {

    @Override
    public Resource getResource(String location) {
        if (StringUtils.isBlank(location)) {
            throw new NullPointerException("Location must not be null");
        }
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            System.out.println("从 ClassPath 处加载资源: " + location);
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        } else {
            try {
                System.out.println("从 URL 处加载资源：" + location);
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                System.out.println("从系统文件处加载资源：" + location);
                return new FileSystemResource(location);
            }
        }
    }
}

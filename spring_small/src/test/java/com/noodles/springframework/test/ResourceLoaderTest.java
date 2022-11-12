package com.noodles.springframework.test;

import com.noodles.springframework.core.io.DefaultResourceLoader;
import com.noodles.springframework.core.io.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * @description: 测试资源类加载
 * @author: liuxian
 * @date: 2022-11-12 11:27
 */
public class ResourceLoaderTest {

    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_classpath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IOUtils.toString(inputStream, Charset.forName("UTF-8"));
        System.out.println(content);
    }

    @Test
    public void test_file() throws IOException {
        Resource resource = resourceLoader.getResource("src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IOUtils.toString(inputStream, Charset.forName("UTF-8"));
        System.out.println(content);
    }

    @Test
    public void test_url() throws IOException {
        Resource resource = resourceLoader.getResource("https://github.com/fuzhengwei/small-spring/blob/main/small-spring-step-05/src/test/resources/important.properties");
        InputStream is = resource.getInputStream();
        String content = IOUtils.toString(is, Charset.forName("UTF-8"));
        System.out.println(content.contains("OLpj9823dZ"));
    }
}

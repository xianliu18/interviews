package com.noodles;

import com.noodles.demo.UserService;

import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.DefaultDocumentLoader;
import org.springframework.beans.factory.xml.DocumentLoader;
import org.springframework.beans.factory.xml.ResourceEntityResolver;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @Description: 测试类
 * @Author: noodles
 * @create: 2021-01-24 19:58
 */
@Slf4j
public class ApiTest {

    @Test
    public void test_XmlBeanFactory() {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("spring-config.xml"));
        UserService userService = beanFactory.getBean("userService", UserService.class);
        log.info("测试结果: {}", userService.queryUserInfo(1000L));
    }

    @Test
    public void test_ClassPathXmlApplicationContext() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        UserService userService = beanFactory.getBean("userService", UserService.class);
        log.info("测试结果: {}", userService.queryUserInfo(2000L));
    }

    @Test
    public void test_DocumentLoader() throws Exception {

        // 设置资源
        EncodedResource encodedResource = new EncodedResource(new ClassPathResource("spring-config.xml"));

        // 加载解析
        InputSource inputSource = new InputSource(encodedResource.getResource().getInputStream());
        DocumentLoader documentLoader = new DefaultDocumentLoader();
        Document doc = documentLoader.loadDocument(inputSource, new ResourceEntityResolver(new PathMatchingResourcePatternResolver()), new DefaultHandler(), 3, false);

        // 输出结果
        Element root = doc.getDocumentElement();
        NodeList nodeList = root.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (!(node instanceof Element)) continue;
            Element ele = (Element)node;
            if (!"bean".equals(ele.getNodeName())) continue;
            String id = ele.getAttribute("id");
            String clazz = ele.getAttribute("class");
            String scope = ele.getAttribute("scope");
            log.info("测试结果: beanName {}, beanClass: {}, scope: {}", id, clazz, scope);
        }
    }
}

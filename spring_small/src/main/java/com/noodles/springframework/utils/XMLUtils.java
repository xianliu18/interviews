package com.noodles.springframework.utils;

import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * @description: XML 解析工具
 * @author: liuxian
 * @date: 2022-11-12 10:39
 */
public class XMLUtils {
    public static Document readXML(InputStream inputStream) {
        Document doc = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.parse(inputStream);
        } catch (ParserConfigurationException | SAXException |IOException  e) {
            throw new RuntimeException("解析 XML 文件异常！");
        }
        return doc;
    }
}

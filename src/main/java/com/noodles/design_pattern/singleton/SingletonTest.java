package com.noodles.design_pattern.singleton;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @ClassName SingletonTest
 * @Description 单例模式测试
 * @Author noodles
 * @Date 2021/2/24 14:27
 */
public class SingletonTest {
    
    /***
     * @Description 单例在序列化时，被破坏
     * @Date 2021/2/24 14:31
     * 参考链接： https://blog.csdn.net/yunfeng482/article/details/91406615
     */
    @Test
    public void serializeTest() throws IOException, ClassNotFoundException {
        ObjectOutputStream tempFile = new ObjectOutputStream(new FileOutputStream("tempFile"));
        tempFile.writeObject(SafeTwoCheckSingleton.getSingleton());
        File file = new File("tempFile");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        SafeTwoCheckSingleton newInstance = (SafeTwoCheckSingleton)ois.readObject();
        // 判断是否是同一个对象
        System.out.println(newInstance == SafeTwoCheckSingleton.getSingleton());
    }

    @Test
    public void serializeTest2() throws IOException, ClassNotFoundException {
        ObjectOutputStream tempFile = new ObjectOutputStream(new FileOutputStream("tempFile"));
        tempFile.writeObject(SafeTwoCheckSingleton2.getSingleton());
        File file = new File("tempFile");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        SafeTwoCheckSingleton2 newInstance = (SafeTwoCheckSingleton2)ois.readObject();
        // 判断是否是同一个对象
        System.out.println(newInstance == SafeTwoCheckSingleton2.getSingleton());
    }
}

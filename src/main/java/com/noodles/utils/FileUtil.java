package com.noodles.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName FileUtil
 * @Description 读取文件工具类
 * @Author noodles
 * @Date 2021/1/14 14:16
 */
public class FileUtil {

    public static Set<String> readWordList(String url) {
        Set<String> set = new HashSet<>();
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(url), StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] ss = line.split("\t");
                set.add(ss[1]);
            }
            br.close();
            isr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return set;
    }
}

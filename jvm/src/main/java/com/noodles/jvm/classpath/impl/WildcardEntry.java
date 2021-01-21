package com.noodles.jvm.classpath.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * @Description: 通配符类型路径
 * @Author: noodles
 * @create: 2021-01-21 08:24
 */
public class WildcardEntry extends CompositeEntry {

    public WildcardEntry(String pathList) {
        super(toPathList(pathList));
    }

    private static String toPathList(String wildcardPath) {
        String baseDir = wildcardPath.replace("*", "");
        try {
            return Files.walk(Paths.get(baseDir))
                    .filter(Files::isRegularFile)
                    .map(Path::toString)
                    .filter(p -> p.endsWith(".jar") || p.endsWith(".JAR"))
                    .collect(Collectors.joining(File.pathSeparator));
        } catch (IOException e) {
            return "";
        }
    }
}

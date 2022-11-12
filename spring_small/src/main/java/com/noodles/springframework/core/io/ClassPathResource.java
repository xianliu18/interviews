package com.noodles.springframework.core.io;

import com.noodles.springframework.utils.ClassUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.lang3.StringUtils;

/**
 * @description: ClassPath 资源
 * @author: liuxian
 * @date: 2022-11-11 18:24
 */
public class ClassPathResource implements Resource{

    private final String path;

    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, (ClassLoader)null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        if (StringUtils.isBlank(path)) {
            throw new NullPointerException("Path must not be null.");
        }
        this.path = path;
        this.classLoader = (classLoader != null) ? classLoader : ClassUtils.getDefaultClassLoader();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = classLoader.getResourceAsStream(path);
        if (is == null) {
            throw new FileNotFoundException(this.path + " cannot be opened because it does not exist");
        }
        return is;
    }
}

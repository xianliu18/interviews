package com.noodles.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @description: 资源接口
 * @author: liuxian
 * @date: 2022-11-11 18:25
 */
public interface Resource {

    InputStream getInputStream() throws IOException;

}

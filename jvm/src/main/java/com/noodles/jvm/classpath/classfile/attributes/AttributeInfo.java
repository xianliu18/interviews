package com.noodles.jvm.classpath.classfile.attributes;

import com.noodles.jvm.classpath.classfile.ClassReader;

public interface AttributeInfo {

    void readInfo(ClassReader reader);
}

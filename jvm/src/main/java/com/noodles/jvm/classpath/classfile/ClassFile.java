package com.noodles.jvm.classpath.classfile;

import com.noodles.jvm.classpath.classfile.attributes.AttributeInfo;

import sun.jvm.hotspot.oops.ConstantPool;

/**
 * @Description:
 * @Author:
 * @create: 2021-01-21 21:41
 */
public class ClassFile {

    private int minorVersion;
    private int majorVersion;
    private ConstantPool constantPool;
    private int accessFlags;
    private int thisClassIdx;
    private int[] interfaces;
    private MemberInfo[] fields;
    private MemberInfo[] methods;
    private AttributeInfo[] attributes;


}

package com.noodles.design_pattern.builder;

/**
 * @ClassName StudentTest
 * @Description Builder测试
 * @Author noodles
 * @Date 2021/2/25 18:17
 */
public class StudentTest {
    public static void main(String[] args) {
        Student stu = new Student.StudentBuilder(1001, "张三", 1, 17)
                                .headTeacherName("吴老师")
                                .className("三年一班").build();
        System.out.println(stu.toString());
    }
}

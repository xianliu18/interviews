package com.noodles.design_pattern.builder;

/**
 * @ClassName Student
 * @Description 构造器创建对象
 * 参考链接：https://blog.csdn.net/u014745069/article/details/84329971
 * @Author noodles
 * @Date 2021/2/25 18:07
 */
public class Student {
    // 必需参数
    private int stuNo;
    private String name;
    private int gender; // 性别：0 代表女生，1 代表男生
    private int age;
    // 可选参数
    private String headTeacherName;
    private String address;
    private String className;
    private String specialty;

    private Student(StudentBuilder builder) {
        this.stuNo = builder.stuNo;
        this.name = builder.name;
        this.gender = builder.gender;
        this.age = builder.age;
        this.headTeacherName = builder.headTeacherName;
        this.address = builder.address;
        this.className = builder.className;
        this.specialty = builder.specialty;
    }

    // 用于构建 Student 对象的构建器类
    public static class StudentBuilder {
        // 必需
        private int stuNo;
        private String name;
        private int gender;
        private int age;

        // 可选
        private String headTeacherName;
        private String address;
        private String className;
        private String specialty;

        public StudentBuilder(int stuNo, String name, int gender, int age) {
            this.stuNo = stuNo;
            this.name = name;
            this.gender = gender;
            this.age = age;
        }

        public StudentBuilder headTeacherName(String headTeacherName) {
            this.headTeacherName = headTeacherName;
            return this;
        }

        public StudentBuilder address(String address) {
            this.address = address;
            return this;
        }

        public StudentBuilder className(String className) {
            this.className = className;
            return this;
        }

        public StudentBuilder specialty(String specialty) {
            this.specialty = specialty;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNo = " + stuNo + ",\n" +
                "name = " + name + ",\n" +
                "gender = " + gender + ",\n" +
                "age = " + age + ",\n" +
                "headTeacherName = " + headTeacherName + ",\n" +
                "address = " + address + ",\n" +
                "className = " + className + ",\n" +
                "specialty = " + specialty + ",\n" +
                "}";
    }
}

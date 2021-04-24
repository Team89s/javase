package com.igeek.javase.day14.stream;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/23 10:34
 */
public class Student {

    private String name;


    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Student{name = " + name + "}";
    }
}

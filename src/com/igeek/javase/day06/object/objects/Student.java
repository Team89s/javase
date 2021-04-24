package com.igeek.javase.day06.object.objects;

/**
 * @version 1.0
 * @Description 学生类  Object常用方法
 * @Author chenmin
 * @Date 2020/11/4 9:17
 */
public class Student{

    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}

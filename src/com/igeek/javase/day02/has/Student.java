package com.igeek.javase.day02.has;

/**
 * @version 1.0
 * @Description 学生
 * @Author chenmin
 * @Date 2020/10/29 14:08
 */
public class Student {

    private String name;

    //一对一关联  双向关联
    private Classes clas;

    public Student() {
    }

    public Student(String name, Classes clas) {
        this.name = name;
        this.clas = clas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Classes getClas() {
        return clas;
    }

    public void setClas(Classes clas) {
        this.clas = clas;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", clas=" + clas +
                '}';
    }
}

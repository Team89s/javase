package com.igeek.javase.day21.reflect.hibernate;

/**
 * @version 1.0
 * @Description Student类
 * @Author chenmin
 * @Date 2020/12/16 9:41
 */
public class Student {

    private String num;
    private String name;
    private int age;
    private char sex;

    public Student() {
    }

    public Student(String num, String name, int age, char sex) {
        this.num = num;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    /**
     * 获取
     * @return num
     */
    public String getNum() {
        return num;
    }

    /**
     * 设置
     * @param num
     */
    public void setNum(String num) {
        this.num = num;
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

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     * @return sex
     */
    public char getSex() {
        return sex;
    }

    /**
     * 设置
     * @param sex
     */
    public void setSex(char sex) {
        this.sex = sex;
    }

    public String toString() {
        return "Student{num = " + num + ", name = " + name + ", age = " + age + ", sex = " + sex + "}";
    }
}

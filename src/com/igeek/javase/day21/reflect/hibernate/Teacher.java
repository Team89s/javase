package com.igeek.javase.day21.reflect.hibernate;

/**
 * @version 1.0
 * @Description Teacher类
 * @Author chenmin
 * @Date 2020/12/16 9:41
 */
public class Teacher {

    private String name;
    private String major;
    private int age;

    public Teacher() {
    }

    public Teacher(String name, String major, int age) {
        this.name = name;
        this.major = major;
        this.age = age;
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
     * @return major
     */
    public String getMajor() {
        return major;
    }

    /**
     * 设置
     * @param major
     */
    public void setMajor(String major) {
        this.major = major;
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

    public String toString() {
        return "Teacher{name = " + name + ", major = " + major + ", age = " + age + "}";
    }
}

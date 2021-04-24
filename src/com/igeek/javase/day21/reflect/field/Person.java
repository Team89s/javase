package com.igeek.javase.day21.reflect.field;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/16 9:18
 */
public class Person {
    private String name;
    private int age;
    private char sex;
    public static String num;
    public static final int LEVEL = 1;

    public Person() {
    }

    public Person(String name, int age, char sex, String num) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.num = num;
    }

    /**
     * 获取
     * @return num
     */
    public static String getNum() {
        return num;
    }

    /**
     * 设置
     * @param num
     */
    public static void setNum(String num) {
        Person.num = num;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        System.out.println("getName()");
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        System.out.println("setName(String)");
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

    public static int getLEVEL() {
        return LEVEL;
    }

    public String toString() {
        return "Person{name = " + name + ", age = " + age + ", sex = " + sex + ", num = " + num + ", LEVEL = " + LEVEL + "}";
    }
}

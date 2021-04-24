package com.igeek.javase.day14.method;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/20 10:49
 */
public class Person {

    private String name;
    private int age;

    public static int compareAge(Person p1,Person p2){
        return p2.getAge() - p1.getAge();
    }

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
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
        return "Person{name = " + name + ", age = " + age + "}";
    }
}

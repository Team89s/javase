package com.igeek.javase.day11.map;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/13 10:24
 */
public class PersonInfo implements Comparable<PersonInfo>{
    private String name;
    private int age;

    public PersonInfo() {
    }

    public PersonInfo(String name, int age) {
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

    @Override
    public int compareTo(PersonInfo o) {
        if(this.age==o.getAge()){
            return this.name.compareTo(o.name);
        }
        return this.age-o.getAge();
    }
}

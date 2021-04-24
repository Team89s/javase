package com.igeek.javase.day10.set.test;

import java.util.Objects;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/12 10:04
 */
public class Student {

    private String name;
    private String num;


    public Student() {
    }

    public Student(String name, String num) {
        this.name = name;
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

    public String toString() {
        return "Student{name = " + name + ", num = " + num + "}";
    }

    /**
     * hashCode()返回固定值1，实现了不好的哈希算法时导致链表过长的情况，
     * 导致hashCode分布离散很差的场景，此时用上策略--转换为红黑树
     */
    /*@Override
    public int hashCode() {
        return 1;
    }
    */

    //Object中的equals()默认比较地址，自定义的类重写equals()，将会按照他的属性进行比较
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        //Objects.equals(name, student.name) 等价于  this.name.equals(student.name)
        return Objects.equals(name, student.name) &&
                Objects.equals(num, student.num);
       //return this==o;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, num);
    }
}

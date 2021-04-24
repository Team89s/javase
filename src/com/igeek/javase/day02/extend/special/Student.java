package com.igeek.javase.day02.extend.special;

/**
 * @version 1.0
 * @Description Student - 子类
 * @Author chenmin
 * @Date 2020/10/28 13:58
 */
public class Student extends Person{

    public Student() {
        super();
    }

    public Student(String name, String sex) {
        super(name, sex);
    }

    public void study(){
        System.out.println(this.getName()+"正在学习...");
    }

    @Override
    public void sleep() {
        System.out.println(this.getName()+"习惯晚睡早起...");
    }
}

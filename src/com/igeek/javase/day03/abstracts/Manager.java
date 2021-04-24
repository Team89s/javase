package com.igeek.javase.day03.abstracts;

/**
 * @version 1.0
 * @Description 经理类
 * @Author chenmin
 * @Date 2020/10/30 16:22
 */
public class Manager extends Employee{

    public Manager() {
        super();
    }

    public Manager(int num, String name, int age, double salary) {
        super(num, name, age, salary);
    }

    @Override
    public void work() {
        System.out.println(this.getName()+"盯梢及开会中...");
    }
}

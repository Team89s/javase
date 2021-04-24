package com.igeek.javase.day02.extend.employeetest;

/**
 * @version 1.0
 * @Description 厨师类
 * @Author chenmin
 * @Date 2020/10/28 15:36
 */
public class Cooker extends Employee {

    public Cooker() {
    }

    public Cooker(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void work() {
        System.out.println(this.getName()+"做饭");
    }
}

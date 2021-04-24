package com.igeek.javase.day02.extend.employeetest;

/**
 * @version 1.0
 * @Description 服务员
 * @Author chenmin
 * @Date 2020/10/28 15:35
 */
public class Waiter extends Employee {

    public Waiter() {
    }

    public Waiter(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void work() {
        System.out.println(this.getName()+"上菜与结账");
    }
}

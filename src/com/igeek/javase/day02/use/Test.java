package com.igeek.javase.day02.use;

/**
 * @version 1.0
 * @Description 测试类
 * @Author chenmin
 * @Date 2020/10/29 14:16
 */
public class Test {

    public static void main(String[] args) {

        Bus bus = new Bus("地铁");

        Person p = new Person("张三");
        p.work(bus);
    }

}

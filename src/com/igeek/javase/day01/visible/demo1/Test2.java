package com.igeek.javase.day01.visible.demo1;

/**
 * @version 1.0
 * @Description 同包下
 * @Author chenmin
 * @Date 2020/10/27 16:24
 */
public class Test2 {

    public static void main(String[] args) {
        Test1 test = new Test1();
        test.name = "lisi";
        test.age = 16;
        test.eat();
    }

}

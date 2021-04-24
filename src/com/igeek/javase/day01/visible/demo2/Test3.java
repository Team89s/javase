package com.igeek.javase.day01.visible.demo2;

import com.igeek.javase.day01.visible.demo1.Test1;

/**
 * @version 1.0
 * @Description 不同包下子类
 * @Author chenmin
 * @Date 2020/10/27 16:24
 */
public class Test3 extends Test1 {

    public static void main(String[] args) {
        //Test1 test = new Test1();
        Test3 test = new Test3();
        test.name = "wangzha";
        test.age = 22;
        test.eat();
    }

}

package com.igeek.javase.pattern.singleton;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/10/30 16:46
 */
public class Test {

    public static void main(String[] args) {

        SingletonDemo1 singleton1 = SingletonDemo1.getInstance();
        SingletonDemo1 singleton2 = SingletonDemo1.getInstance();
        System.out.println(singleton1);
        System.out.println(singleton2);
        System.out.println(singleton1 == singleton2);  //true

        SingletonDemo2 singleton3 = SingletonDemo2.getInstance();
        SingletonDemo2 singleton4 = SingletonDemo2.getInstance();
        System.out.println(singleton3 == singleton4);  //true

    }

}

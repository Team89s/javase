package com.igeek.javase.day03.singleton;

/**
 * @version 1.0
 * @Description 单例模式 - 静态内部类的单例设计模式
 * @Author chenmin
 * @Date 2020/10/30 16:41
 *
 * 单例模式：统一对外提供一个实例
 *      1.单例模式，是一种常用的软件设计模式。
 *      2.通过单例模式可以保证系统中，应用该模式的这个类只有一个实例。即一个类只有一个对象实例。
 *
 * 1. 饿汉单例设计模式
 * 2. 懒汉单例设计模式
 * 3. 静态内部类的单例设计模式：延迟加载获得实例   线程安全
 * 4. 线程安全的单例设计模式  DCL
 */
public class SingletonDemo3 {

    //2.私有化的构造方法
    private SingletonDemo3(){

    }

    //私有的 静态内部类的单例
    private static class InnerClass{
        //1.私有的  静态的   实例
        private static SingletonDemo3 singleton = new SingletonDemo3();
    }

    //3.公开的静态的获得本类实例的方法
    public static SingletonDemo3 getInstance(){
        return InnerClass.singleton;
    }

    public static void main(String[] args) {
        SingletonDemo3 instance1 = SingletonDemo3.getInstance();
        SingletonDemo3 instance2 = SingletonDemo3.getInstance();
        System.out.println(instance1 == instance2);  //true
    }
}

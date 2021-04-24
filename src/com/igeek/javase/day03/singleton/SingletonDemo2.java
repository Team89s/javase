package com.igeek.javase.day03.singleton;

/**
 * @version 1.0
 * @Description 单例模式 - 懒汉单例设计模式
 * @Author chenmin
 * @Date 2020/10/30 16:41
 *
 * 单例模式：统一对外提供一个实例
 *      1.单例模式，是一种常用的软件设计模式。
 *      2.通过单例模式可以保证系统中，应用该模式的这个类只有一个实例。即一个类只有一个对象实例。
 *
 * 1. 饿汉单例设计模式
 * 2. 懒汉单例设计模式
 * 3. 静态内部类的单例设计模式
 * 4. 线程安全的单例设计模式
 */
public class SingletonDemo2 {

    //1.私有的  静态的   实例
    private static SingletonDemo2 singleton;

    //2.私有的构造方法
    private SingletonDemo2(){

    }

    //3.公开的静态的返回当前实例的方法
    public static SingletonDemo2 getInstance(){
        if(singleton==null){
            singleton = new SingletonDemo2();
        }
        return singleton;
    }

}

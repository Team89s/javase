package com.igeek.javase.day16.serializable;

import java.io.Serializable;

/**
 * @version 1.0
 * @Description 单例模式
 * @Author chenmin
 * @Date 2020/11/26 14:07
 */
public class Singleton implements Serializable {

    private static final long serialVersionUID = -3822062398332767763L;

    private Singleton(){

    }

    /**
     * 静态内部类
     */
    private static class InnerClass{
        private static final Singleton singleton = new Singleton();
    }

    public static Singleton getInstance(){
        return InnerClass.singleton;
    }

    //定义一个方法，返回当前实例
    private Object readResolve(){
        return InnerClass.singleton;  //true 反序列化获得对象与单例提供的对象保证了一致
    }

}

package com.igeek.javase.day21.reflect.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @version 1.0
 * @Description 反射破解封装性 - 懒汉式线程安全的单例模式
 * @Author chenmin
 * @Date 2020/12/16 10:26
 */
public class Singleton2 {

    private static volatile Singleton2 singleton;

    private Singleton2(){
        synchronized (Singleton2.class){
            if(singleton!=null){
                throw new RuntimeException("不要试图通过反射创建对象");
            }
        }
    }

    public static Singleton2 getInstance(){
        if(singleton==null){
            synchronized(Singleton2.class){
                if(singleton==null){
                    singleton = new Singleton2();
                }
            }
        }
        return singleton;
    }
}

class Test2{
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Singleton2 instance1 = Singleton2.getInstance();

        //反射创建单例对象
        Class clazz = Singleton2.class;
        Constructor c = clazz.getDeclaredConstructor();
        c.setAccessible(true); //暴力破解
        Singleton2 instance2 = (Singleton2)c.newInstance();

        System.out.println(instance1);
        System.out.println(instance2);
        System.out.println(instance1 == instance2);  //false
    }
}

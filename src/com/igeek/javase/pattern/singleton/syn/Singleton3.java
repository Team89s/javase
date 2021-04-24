package com.igeek.javase.pattern.singleton.syn;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @version 1.0
 * @Description 反射破解封装性 - 懒汉式线程安全的单例模式
 * @Author chenmin
 * @Date 2020/12/16 10:26
 */
public class Singleton3 {

    private static volatile Singleton3 singleton;

    private static boolean qwe = false;

    private Singleton3(){
        synchronized (Singleton3.class){
            if(!qwe){
                qwe = true;
            }else{
                throw new RuntimeException("不要试图通过反射创建对象");
            }
        }
    }

    public static Singleton3 getInstance(){
        if(singleton==null){
            synchronized(Singleton3.class){
                if(singleton==null){
                    singleton = new Singleton3();
                }
            }
        }
        return singleton;
    }
}

class Test3{
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //反射创建单例对象
        Class clazz = Singleton3.class;
        Constructor c = clazz.getDeclaredConstructor();
        c.setAccessible(true); //暴力破解
        //创建对象
        Singleton3 instance1 = (Singleton3)c.newInstance();
        Singleton3 instance2 = (Singleton3)c.newInstance();

        System.out.println(instance1);
        System.out.println(instance2);
        System.out.println(instance1 == instance2);  //false
    }
}

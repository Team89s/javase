package com.igeek.javase.pattern.singleton.syn;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @version 1.0
 * @Description 反射破坏封装性 - 懒汉式线程安全的单例模式
 * @Author chenmin
 * @Date 2020/12/16 10:26
 */
public class Singleton4 {

    private static volatile Singleton4 singleton;

    private static boolean qwe = false;

    private Singleton4(){
        synchronized (Singleton4.class){
            if(!qwe){
                qwe = true;
            }else{
                throw new RuntimeException("不要试图通过反射创建对象");
            }
        }
    }

    public static Singleton4 getInstance(){
        if(singleton==null){
            synchronized(Singleton4.class){
                if(singleton==null){
                    singleton = new Singleton4();
                }
            }
        }
        return singleton;
    }
}

class Test4{
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        //反射创建单例对象
        Class clazz = Singleton4.class;
        Constructor c = clazz.getDeclaredConstructor();
        c.setAccessible(true); //暴力破解
        //创建对象
        Singleton4 instance1 = (Singleton4)c.newInstance();

        Field qweField = clazz.getDeclaredField("qwe");
        qweField.setAccessible(true);//暴力破解
        //修改属性
        qweField.set(instance1,false);

        //创建
        Singleton4 instance2 = (Singleton4)c.newInstance();

        System.out.println(instance1);
        System.out.println(instance2);
        System.out.println(instance1 == instance2);  //false
    }
}

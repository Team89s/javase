package com.igeek.javase.day21.reflect.constructor;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @version 1.0
 * @Description 反射中 - 构造器对象
 * @Author chenmin
 * @Date 2020/12/15 15:56
 *
 * 反射可以破坏原有的封装性（暴力破解）
 *
 * Constructor类概述
 *    类中的每一个构造方法都是一个Constructor类的对象
 *
 * Class类中提供的获取Constructor构造器对象的方法：
 * Constructor getDeclaredConstructor(Class... parameterTypes)
 *    根据参数类型获得对应的Constructor对象，包括private
 *
 * Constructor中的常用方法
 * 1. T newInstance(Object... initargs)
 *  	根据指定的参数创建对象
 * 2. void setAccessible(true)  (暴力反射)
 *    设置是否取消权限检查，true取消权限检查，false表示不取消
 */
public class ConstructorDemo2 {

    @Test
    public void test1() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获取Student的类类型
        Class clazz = Student.class;

        //获取Student中指定的构造方法
        Constructor c = clazz.getDeclaredConstructor(String.class, int.class);
        //创建对象
        Object instance = c.newInstance("张三", 10);
        System.out.println(instance);
    }

    @Test
    public void test2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获取Student的类类型
        Class clazz = Student.class;

        //获取Student中指定的构造方法
        Constructor c = clazz.getDeclaredConstructor();  //获取无参构造器对象
        //若没有解除访问权限问题，则抛出IllegalAccessException异常   当为true时，暴力破解私有化的访问权限
        c.setAccessible(true);
        //创建对象
        Object instance = c.newInstance();
        System.out.println(instance);
    }
}

package com.igeek.javase.day21.reflect.constructor;

import org.junit.Test;

import java.lang.reflect.Constructor;

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
 * 1. Constructor getConstructor(Class... parameterTypes)
 *    根据参数类型获得对应的Constructor对象。只能获得public修饰的构造方法
 *
 * 2. Constructor getDeclaredConstructor(Class... parameterTypes)
 *    根据参数类型获得对应的Constructor对象，包括private
 *
 * 3. Constructor[] getConstructors()
 *    获得类中的所有构造方法对象，只能获得public的
 *
 * 4. Constructor[] getDeclaredConstructors()
 *    获得类中的所有构造方法对象，包括private修饰的
 */
public class ConstructorDemo1 {

    //3.Constructor[] getConstructors() 获得类中的所有构造方法对象，只能获得public的
    @Test
    public void test1(){
        //获取Student的类类型
        Class clazz = Student.class;
        //获取Student中所有公开public的构造方法
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName()+" === "+constructor.getParameterCount());  //2
        }
    }

    //4.Constructor[] getDeclaredConstructors() 获得类中的所有构造方法对象，包括private修饰的
    @Test
    public void test2(){
        //获取Student的类类型
        Class clazz = Student.class;
        //获取Student中所有的构造方法
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName()+" === "+constructor.getParameterCount());  //3
        }
    }

    //1. Constructor getConstructor(Class... parameterTypes)
    // 根据参数类型获得对应的Constructor对象。只能获得public修饰的构造方法
    @Test
    public void test3() throws NoSuchMethodException {
        //获取Student的类类型
        Class clazz = Student.class;
        //获取Student中指定的构造方法
        //Constructor constructor = clazz.getConstructor();  //无参构造方法，报错NoSuchMethodException
        Constructor constructor1 = clazz.getConstructor(String.class);
        Constructor constructor2 = clazz.getConstructor(String.class,int.class);
        System.out.println(constructor1.getName()+" === "+constructor1.getParameterCount());
        System.out.println(constructor2.getName()+" === "+constructor2.getParameterCount());
    }

    //2. Constructor getDeclaredConstructor(Class... parameterTypes)
    //   根据参数类型获得对应的Constructor对象，包括private
    @Test
    public void test4() throws NoSuchMethodException {
        //获取Student的类类型
        Class clazz = Student.class;
        //获取Student中指定的构造方法
        Constructor constructor = clazz.getDeclaredConstructor();  //无参构造方法
        Constructor constructor1 = clazz.getDeclaredConstructor(String.class);
        Constructor constructor2 = clazz.getDeclaredConstructor(String.class,int.class);
        System.out.println(constructor.getName()+" === "+constructor.getParameterCount());
        System.out.println(constructor1.getName()+" === "+constructor1.getParameterCount());
        System.out.println(constructor2.getName()+" === "+constructor2.getParameterCount());
    }
}

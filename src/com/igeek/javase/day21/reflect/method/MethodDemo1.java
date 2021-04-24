package com.igeek.javase.day21.reflect.method;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @version 1.0
 * @Description Method类
 * @Author chenmin
 * @Date 2020/12/15 16:23
 *
 * Method类概述：每一个成员方法都是一个Method类的对象。
 *
 * Class类中获取Method对象的的方法：
 * 1.Method getMethod(String name,Class...args);
 *     * 根据方法名和参数类型获得对应的构造方法对象，只能获得public的
 *
 * 2.Method getDeclaredMethod(String name,Class...args);
 *     * 根据方法名和参数类型获得对应的构造方法对象，包括private的
 *
 * 3.Method[] getMethods();
 *     * 获得类中的所有成员方法对象，返回数组，只能获得public修饰的且包含父类的
 *
 * 4.Method[] getDeclaredMethods();
 *     * 获得类中的所有成员方法对象，返回数组,只获得本类的，包含private修饰的
 */
public class MethodDemo1 {

    //1.Method getMethod(String name,Class...args);
    //  根据方法名和参数类型获得对应的构造方法对象，只能获得public的
    // 第一个参数：通过反射获取的方法的名称 ； 第二个参数：方法中的形参列表
    @Test
    public void test1() throws NoSuchMethodException {
        Class<User> clazz = User.class;
        //Method sleepMethod = clazz.getMethod("sleep", int.class);  当前方法是私有化的，报错
        Method workMethod = clazz.getMethod("work", String.class);
        System.out.println(workMethod.getName()+" === "+workMethod.getParameterCount());
    }

    //2.Method getDeclaredMethod(String name,Class...args);  忽略访问权限获取方法对象
    //  根据方法名和参数类型获得对应的构造方法对象，包括private的
    @Test
    public void test2() throws NoSuchMethodException {
        Class<User> clazz = User.class;
        Method sleepMethod = clazz.getDeclaredMethod("sleep", int.class);
        System.out.println(sleepMethod.getName()+" === "+sleepMethod.getParameterCount());
    }

    //3.Method[] getMethods();
    // 获得类中的所有成员方法对象，返回数组，只能获得public修饰的且包含父类的(包括Object)
    @Test
    public void test3() throws NoSuchMethodException {
        Class<User> clazz = User.class;
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }

    //4.Method[] getDeclaredMethods();
    //  获得类中的所有成员方法对象，返回数组,只获得本类的，包含private修饰的
    @Test
    public void test4() throws NoSuchMethodException {
        Class<User> clazz = User.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }
}

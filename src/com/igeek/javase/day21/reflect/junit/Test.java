package com.igeek.javase.day21.reflect.junit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @version 1.0
 * @Description 测试自定义的@MyTest注解
 * @Author chenmin
 * @Date 2020/12/16 16:22
 *
 * 期望效果：只有含@MyTest注解的方法，才可以运行
 */
public class Test {

    @MyTest
    public void dosth1(){
        System.out.println("dosth1() 执行了");
    }

    public void dosth2(){
        System.out.println("dosth2() 执行了");
    }

    @MyTest
    public void dosth3(){
        System.out.println("dosth3() 执行了");
    }

    @MyTest
    public void dosth4(){
        System.out.println("dosth4() 执行了");
    }

    //模拟run运行的按钮
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Test test = new Test();
        Class<Test> clazz = Test.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if(method.isAnnotationPresent(MyTest.class)){
                method.invoke(test);
            }
        }
    }

}

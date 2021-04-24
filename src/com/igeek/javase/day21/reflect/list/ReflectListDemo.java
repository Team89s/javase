package com.igeek.javase.day21.reflect.list;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/16 10:16
 *
 * 反射：
 * 1.破坏封装性
 * 2.破坏集合的泛型
 *
 *
 */
public class ReflectListDemo {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //集合的泛型，其实编译期的规范，并不存在在运行期
        List<Integer> list = new ArrayList<>();
        list.add(111);
        list.add(222);
        list.add(333);
        //list.add("abc");

        // 反射是一种机制，利用该机制可以在程序运行过程中对类进行解剖并操作类中的所有成员(成员变量，成员方法，构造方法)
        Class<? extends List> clazz = list.getClass();
        //获得集合中的add添加方法的对象
        Method addMethod = clazz.getDeclaredMethod("add", Object.class);
        //执行add方法
        addMethod.invoke(list,"abc");
        System.out.println(list);
    }
}

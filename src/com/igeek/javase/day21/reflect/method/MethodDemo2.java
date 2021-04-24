package com.igeek.javase.day21.reflect.method;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @version 1.0
 * @Description Method类
 * @Author chenmin
 * @Date 2020/12/15 16:37
 *
 *  Method getDeclaredMethod(String name,Class...args);
 *  根据方法名和参数类型获得对应的构造方法对象，包括private的
 *
 *  Method对象常用方法:
 *  Object invoke(Object obj, Object... args) 调用指定对象obj的该方法
 *     args：调用方法时传递的参数
 *  void setAccessible(true)
 *     设置是否取消权限检查，true取消权限检查，false表示不取消(暴力反射)
 */
public class MethodDemo2 {

    @Test
    public void test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<User> clazz = User.class;
        /**
         * getDeclaredMethod(String,Class)  获得将要操作的方法对象
         * 第一个参数：获取执行的方法名
         * 第二个参数：将要执行的方法的参数列表类型
         */
        Method sleepMethod = clazz.getDeclaredMethod("sleep", int.class);
        //取消访问权限修饰符检查
        sleepMethod.setAccessible(true);
        //执行方法
        User user = new User();
        Object returnObj = sleepMethod.invoke(user, 10);  //若当前方法没有返回值，则是null
        System.out.println(returnObj);  //执行方法的返回值
        System.out.println("user = "+user);  //user = User{name = null, pwd = null, age = 0}
    }

}

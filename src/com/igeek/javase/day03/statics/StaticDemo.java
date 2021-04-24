package com.igeek.javase.day03.statics;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/10/30 14:28
 *
 * 疑问：
 *  *       1.实例方法中可不可以访问实例成员变量？  可以
 *  *       2.实例方法中可不可以访问实例方法？  可以
 *  *       3.实例方法中可不可以访问静态成员变量？  可以
 *  *       4.实例方法中可不可以访问静态方法？  可以
 *  *    -------------------------------------------
 *  *       1.静态方法中可不可以访问静态成员变量？  可以
 *  *       2.静态方法中可不可以访问静态方法？  可以
 *  *       3.静态方法中可不可以访问实例成员变量？  不可以
 *  *       4.静态方法中可不可以访问实例方法？  不可以
 *
 *  总结：静态的资源随着类加载而加载，有且只有一份，静态资源是属于类的，所有对象共享
 *
 */
public class StaticDemo {

    private static int a;
    private int b;

    public static void amethod(){

    }

    public void bmethod(){

    }

    public void test1(){
        System.out.println("a = "+a);
        System.out.println("b = "+b);
        amethod();
        bmethod();
    }

    public static void test2(){
        System.out.println("a = "+a);
        amethod();

        //非静态的资源必须由对象进行调用
        //System.out.println("b = "+b);
        //bmethod();
    }

}




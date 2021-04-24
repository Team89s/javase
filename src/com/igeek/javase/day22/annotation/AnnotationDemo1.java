package com.igeek.javase.day22.annotation;

/**
 * @version 1.0
 * @Description 注解
 * @Author chenmin
 * @Date 2020/12/16 14:30
 *
 * 注解(Annotation)
 * 1.相当于一种标记，在程序中加入注解就等于为程序打上某种标记，
 * 2.以后，javac编译器、开发工具和其他程序可以通过反射来了解你的类及各种元素上有无何种标记，
 * 看你的程序有什么标记，就去干相应的事。
 * 3.标记可以加在包、类，属性、方法，方法的参数以及局部变量上。
 *
 * 如何声明一个注解？
 *      语法：@interface  注解名{  }
 * 如何使用一个注解？
 *      语法：@注解名
 * 注解可以放在哪里使用？
 *      默认可以放在包、类，属性、方法，方法的参数以及局部变量上。
 *
 * 常见注解：
 * @Override方法重写
 * @FunctionalInterface函数式接口
 */
@MyAnno1
public class AnnotationDemo1 {
    @MyAnno1
    @MyAnno2
    private String name;

    @MyAnno1
    public void run(@MyAnno1 int a){

    }
}
//声明一个注解
@interface MyAnno1{

}

@interface MyAnno2{

}

package com.igeek.javase.day22.annotation.book;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 需求：
 * 1. 定义注解Book，要求如下：
 *    - 包含属性：String value()   书名
 *    - 包含属性：double price()  价格，默认值为 100
 *    - 包含属性：String[] authors() 多位作者
 *    - 限制注解使用的位置：类和成员方法上
 *    - 指定注解的有效范围：RUNTIME
 * 2. 定义BookStore类，在类和成员方法上使用Book注解
 * 3. 定义TestAnnotation测试类获取Book注解上的数据
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyBook {
    //书名
    String value();
    //价格
    double price() default 100;
    //多位作者
    String[] authors();
}

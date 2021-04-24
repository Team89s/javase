package com.igeek.javase.day22.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @version 1.0
 * @Description 元注解
 * @Author chenmin
 * @Date 2020/12/16 15:10
 *
 * 元注解的概念：
 * 1.Java官方提供的注解
 * 2.用来定义注解的注解
 * 3.任何官方提供的非元注解的定义都使用到了元注解。
 *
 * 常用的元注解
 *     @Target
 *         * 作用：用来标识注解使用的位置，如果没有使用该注解标识，则自定义的注解可以使用在任意位置。
 *         * 可使用的值定义在ElementType枚举类中，
 *         常用值如下
 *             TYPE，类，接口
 *             FIELD, 成员变量
 *             METHOD, 成员方法
 *             PARAMETER, 方法参数
 *             CONSTRUCTOR, 构造方法
 *             LOCAL_VARIABLE, 局部变量
 *
 *     @Retention
 *         * 作用：用来标识注解的生命周期(有效范围)
 *         * 可使用的值定义在RetentionPolicy枚举类中，
 *         常用值如下
 *             * SOURCE：注解只作用在源码阶段，生成的字节码文件中不存在
 *             * CLASS：注解作用在源码阶段，字节码文件阶段，运行阶段不存在，默认值
 *             * RUNTIME：注解作用在源码阶段，字节码文件阶段，运行阶段（常用）
 */
@MyAnno3
public class AnnotationDemo3 {
    @MyAnno3
    private String name;

    //@MyAnno3
    public void run(){

    }
}
@Target({ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno3{

}

package com.igeek.javase.day22.annotation;

/**
 * @version 1.0
 * @Description  注解解析
 * @Author chenmin
 * @Date 2020/12/16 15:10
 *
 * 注解解析的概念：
 *      使用Java技术获得注解上数据的过程则称为注解解析。
 *
 * 注解解析的相关API：
 * 1.Annotation  接口  注解类，该类是所有注解的父类。
 * 2.AnnotatedElement 接口  --> 实现类：Constructor、Class、Field、Method
 * 3.AnnotatedElement:该接口定义了与注解解析相关的方法
 *       T getAnnotation(Class<T> annotationClass)
 *       根据注解类型获得对应注解对象
 *
 *       Annotation[]	getAnnotations()
 *       获得当前对象上使用的所有注解，返回注解数组，包含父类继承的
 *
 *       Annotation[]	getDeclaredAnnotations()
 *       获得当前对象上使用的所有注解，返回注解数组,只包含本类的
 *
 *       boolean	isAnnotationPresent(Class<Annotation> annotationClass)
 *       判断当前对象是否使用了指定的注解，如果使用了则返回true，否则false
 *
 * 注解解析过程：
 * 1. 注解作用在哪个成员（类、方法、构造方法、属性等）上，
 * 就会得该成员对应的对象（Class、Method、Constructor、Field），来获得成员上的注解
 * 2. 通过AnnotatedElement中提供的“isAnnotationPresent”方法判断是否含有指定注解
 * 3. 直接获取注解的属性值
 *
 */
public class AnnotationDemo4 {



}

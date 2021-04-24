package com.igeek.javase.day09.generic;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @version 1.0
 * @Description 泛型通配符  ?   K T V E
 * @Author chenmin
 * @Date 2020/11/10 9:25
 *
 * 泛型：
 * 1.可以在类或方法声明时预支地使用未知的类型
 * 2.当前集合元素添加时要求更为严格 泛型要求添加 ，最广泛适用于集合Collection<?>
 * 3.泛型通配符  ?
 * 上边界  <? extends Number> 传递进来的数据类型要么是Number本身，要么是Number的子类
 * 下边界  <? super Number>   传递进来的数据类型要么是Number本身，要么是Number的父类
 * 4.优势：要更为严格
 * 5.劣势：
 * 上边界  不允许添加数据，但是可以获取数据
 * 下边界  允许添加数据，但是获取数据只能是Object类型
 */
public class GenDemo3 {

    //上边界  <? extends Number>
    public static void do1(Collection<? extends Number> c){
        //不允许添加数据
        //c.add(123);
        //可以获取数据
        for (Number number : c) {
            System.out.println(number);
        }
    }

    //下边界  <? super Number>
    public static void do2(Collection<? super Number> c){
        //允许添加数据
        c.add(123);
        //获取数据只能是Object类型
        for (Object o : c) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        Collection<Integer> c1 = new ArrayList<>();
        Collection<Number> c2 = new ArrayList<>();
        Collection<String> c3 = new ArrayList<>();
        Collection<Object> c4 = new ArrayList<>();

        GenDemo3.do1(c1);    //Integer是Number的子类
        GenDemo3.do1(c2);    //是Number本身
        //GenDemo3.do1(c3);  编译不通过
        //GenDemo3.do1(c4);  编译不通过


        //GenDemo3.do2(c1);  编译不通过
        GenDemo3.do2(c2);    //是Number本身
        //GenDemo3.do2(c3);  编译不通过
        GenDemo3.do2(c4);    //Object是Number的父类
    }

}

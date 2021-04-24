package com.igeek.javase.day09.generic;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @version 1.0
 * @Description 泛型通配符  ?
 * @Author chenmin
 * @Date 2020/11/9 16:15
 *
 * 泛型通配符  ?
 * 1.一般使用场景：集合中
 * 2.<? extends Number>  传递进来的类型必须是Number的子类或者同类
 * 3.<? super Number>  传递进来的类型必须是Number的父类或者同类
 */
public class GenericDemo5 {

    //上边界
    public static void addExtends(Collection<? extends Number> c){

    }

    //下边界
    public static void addSuper(Collection<? super Number> c){

    }


    public static void main(String[] args) {
        ArrayList<Number> arr1 = new ArrayList<>();  //同类
        arr1.add(123);

        ArrayList<Integer> arr2 = new ArrayList<>(); //子类
        arr2.add(111);

        ArrayList<Object> arr3 = new ArrayList<>();  //父类
        arr3.add("hello");

        //上边界
        GenericDemo5.addExtends(arr1);
        GenericDemo5.addExtends(arr2);
        //GenericDemo5.addExtends(arr3);

        //下边界
        GenericDemo5.addSuper(arr1);
        //GenericDemo5.addSuper(arr2);
        GenericDemo5.addSuper(arr3);
    }

}

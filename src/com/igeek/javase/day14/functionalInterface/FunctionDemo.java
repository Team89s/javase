package com.igeek.javase.day14.functionalInterface;

import java.util.function.Function;

/**
 * @version 1.0
 * @Description Function 接口
 * @Author chenmin
 * @Date 2020/11/20 15:50
 *
 * Function<T,R> 接口   函数式接口
 * 1.R apply(T t)
 * 2.default andThen(Function<T,R> f) 组合操作
 * 3.根据泛型的类型，将前者T类型转换成后者R类型
 */
public class FunctionDemo {

    //将String 转换成 Integer类型
    public static void transfer(Function<String,Integer> function,String str){
        Integer i = function.apply(str);
        System.out.println("i = "+i);
    }

    //先将String 转换成 Integer类型，再乘以10，计算结果
    public static Integer testAndThen(Function<String,Integer> f1,Function<Integer,Integer> f2,String str){
        Integer i = f1.andThen(f2).apply(str);
        return i;
    }

    public static void main(String[] args) {
        //匿名函数
        transfer(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                int i = Integer.parseInt(s);
                return i;
            }
        },"220");

        //Lambda简化
        transfer(s ->{
            int i = Integer.parseInt(s);
            return i;
        },"220");

        System.out.println("-----------------");

        //测试andThen
        Integer i = testAndThen(
                a -> Integer.parseInt(a),
                b -> b * 10,
                "110"
        );
        System.out.println("i = "+i);
    }

}

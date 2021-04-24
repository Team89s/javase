package com.igeek.javase.day14.functionalInterface.test;

import java.util.function.Function;

/**
 * @version 1.0
 * @Description Function<T,R> 接口
 * @Author chenmin
 * @Date 2020/11/20 16:18
 *
 * 请使用Function进行函数模型的拼接，按照顺序需要执行的多个函数操作为：
 * String str = "张三,20";
 * 将字符串截取数字年龄部分，得到字符串；
 * 将上一步的字符串转换成为int类型的数字；
 * 将上一步的int数字加上100，得到结果int数字。
 */
public class FunctionTest {

    public static void change(Function<String,String> f1,Function<String,Integer> f2,
                 Function<Integer,Integer> f3,String str){
        Integer i = f1.andThen(f2).andThen(f3).apply(str);
        System.out.println("i = "+i);
    }

    public static void main(String[] args) {
        String str = "张三,20";

        change(
                a -> str.split(",")[1] ,
                b -> Integer.parseInt(b),
                c -> c+100,
                str
        );
    }

}

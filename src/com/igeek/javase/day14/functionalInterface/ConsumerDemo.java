package com.igeek.javase.day14.functionalInterface;

import java.util.function.Consumer;

/**
 * @version 1.0
 * @Description Consumer<T> 接口
 * @Author chenmin
 * @Date 2020/11/20 14:59
 *
 * Consumer<T>  函数式接口
 * 1.accept(T t)
 * 2.消费型
 * 3.default andThen()  默认的方法
 * 特点：提供一个与泛型一致数据类型的参数
 *
 */
public class ConsumerDemo {

    //accept(T t)
    public static void print(Consumer<String> consumer,String str){
        consumer.accept(str);
    }

    //andThen(Consumer<T> c)  组合操作
    public static void printAndThen(Consumer<String> c1,Consumer<String> c2,String str){
        c1.andThen(c2).accept(str);
    }

    public static void main(String[] args) {
        //匿名内部类
        print(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s.toUpperCase());
            }
        },"Hello World");  //HELLO WORLD

        //Lambda简化
        print(s -> System.out.println(s.toUpperCase()) ,"Hello World");  //HELLO WORLD

        System.out.println("-------------");


        //侧首andThen （了解）
        printAndThen(
                s -> System.out.println(s.toUpperCase()),  //HELLO JAVA
                s -> System.out.println(s.toLowerCase()),  //hello java
                "Hello Java"
        );


    }

}

package com.igeek.javase.day14.functionalInterface;

import java.time.LocalDateTime;

/**
 * @version 1.0
 * @Description 函数式接口
 * @Author chenmin
 * @Date 2020/11/20 11:15
 *
 * 函数式接口 - 应用Lambda表达式使用
 * 优势：
 * 1.简化代码编写，例如：简化了匿名内部类的写法
 * 2.延迟加载效果，例如：满足级别后，日志写入
 */
public class FunctionnalDemo1 {

    public static void main(String[] args) {
        String a = LocalDateTime.now().toString();
        String b = "NullPointException";
        String c = "BAMS.register()";

        //此时级别不满足输出日志的情况，但是仍然做了字符串拼接操作
        showLog(1,a+" "+b+" "+c);

        //引入Lambda表达式，延迟加载的效果
        showLogLambda(1, new MyFunctionalInterface() {
            @Override
            public String test() {
                System.out.println("Lambda表达式执行了！");
                return a+" "+b+" "+c;
            }
        });

        //简化：
        showLogLambda(1, () ->{
            System.out.println("Lambda表达式执行了！");
            return a+" "+b+" "+c;
        });
    }

    //方式一：输出日志
    public static void showLog(int level,String log){
        if(level==3){
            System.out.println(log);
        }
    }

    //方式二：输出日志  Lambda
    public static void showLogLambda(int level,MyFunctionalInterface my){
        if(level==3){
            System.out.println(my.test());
        }
    }
}
//函数式接口：要求是个接口，且只有一个抽象方法
@FunctionalInterface
interface MyFunctionalInterface{
    String test();
}

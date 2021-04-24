package com.igeek.javase.day14.functionalInterface;

import java.util.function.Predicate;

/**
 * @version 1.0
 * @Description Predicate<T> 接口
 * @Author chenmin
 * @Date 2020/11/20 16:25
 *
 * Predicate<T> 接口  函数式接口
 * 1.boolean test(T t);  返回true/false
 * 2.default Predicate<T> and(Predicate<? super T> other)  与
 * default Predicate<T> negate()  非
 * default Predicate<T> or(Predicate<? super T> other)  或
 * 3.对某种类型的数据进行判断，从而得到一个boolean值结果
 */
public class PredicateDemo {

    //测试test方法
    public static void methodTest(Predicate<String> predicate,String str){
        boolean flag = predicate.test(str);
        System.out.println("当前字符串长度是否大于5？"+flag);
    }

    //测试and 与
    public static void methodAnd(Predicate<String> p1,Predicate<String> p2,String str){
        boolean flag = p1.and(p2).test(str);
        System.out.println("该字符串是否同时包含H和W？"+flag);
    }

    //测试or 或
    public static void methodOr(Predicate<String> p1,Predicate<String> p2,String str){
        boolean flag = p1.or(p2).test(str);
        System.out.println("该字符串是否包含H或W？"+flag);
    }

    //测试negate 非
    public static void methodNegate(Predicate<String> p,String str){
        boolean flag = p.negate().test(str);
        System.out.println("当前字符串长度是否大于5？"+flag);
    }

    public static void main(String[] args) {
        //匿名内部类
        methodTest(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                if(s.length()>5){
                    return true;
                }
                return false;
            }
        },"Hello world");

        //简化Lambda表达式
        methodTest(s -> s.length()>5 ? true : false ,"Hello world");

        System.out.println("---------and----------");
        //测试and 与
        methodAnd(
                a ->a.contains("H") ,
                b ->b.contains("W"),
                "Hello Java"
        );  //false

        System.out.println("---------or----------");
        methodOr(
                a -> a.contains("H"),
                b -> b.contains("W"),
                "Hello Java"
        );  //true

        System.out.println("---------negate----------");
        methodNegate(
                s -> s.length()>5 ,
                "Hello Java"
        ); //false
    }

}

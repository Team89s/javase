package com.igeek.javase.day09.generic;

/**
 * @version 1.0
 * @Description 泛型方法
 * @Author chenmin
 * @Date 2020/11/9 16:15
 *
 * 泛型方法：
 * 1.语法：public <T> 返回值类型 方法名(形参数据类型){ //方法体 }
 * 2.泛型的作用域：在当前的方法中
 */
public class GenericDemo4 {

    public static <T> void work(T t){
        if(t instanceof Tiger){
            ((Tiger) t).eat();
        }
        if(t instanceof Dog){
            ((Dog) t).eat();
        }
        System.out.println("工作中...");
    }

    public static void main(String[] args) {
        GenericDemo4 gen = new GenericDemo4();
        gen.work(new Tiger());
        gen.work(new Dog());
    }
}

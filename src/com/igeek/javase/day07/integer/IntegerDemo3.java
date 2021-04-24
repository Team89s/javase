package com.igeek.javase.day07.integer;

/**
 * @version 1.0
 * @Description 值传递
 * @Author chenmin
 * @Date 2020/11/5 11:04
 *
 * 值传递：将实参的值传递给形参
 *      1.基本数据类型值传递：形参改变，实参不变
 *      2.引用数据类型值传递：形参改变，实参改变
 *      3.String值传递：形参改变，实参不变
 *      4.包装器类型值传递：形参改变，实参不变
 */
public class IntegerDemo3 {

    public static void main(String[] args) {
        Integer in1 = new Integer(127);
        change(in1);
        System.out.println("main():"+in1); //127
    }


    public static void change(Integer i){
        i+=1;
        System.out.println("change(i):"+i);  //128
    }

}

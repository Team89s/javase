package com.igeek.javase.day08;

/**
 * @version 1.0
 * @Description 异常的产生过程解析
 * @Author chenmin
 * @Date 2020/11/6 11:14
 *
 * 异常产生的过程：
 *      1.存在异常的代码中产生了异常，紧接着向上抛，抛给了调用者（main方法）
 *      2.main方法中代码出现了异常，紧接着向上抛，抛给了JVM  java虚拟机
 *      3.java虚拟机  显示一堆的红色异常堆栈异常信息  整个程序运行终止
 *      4.程序员解决bug
 */
public class ExceptionDemo2 {

    public static void main(String[] args) {
        System.out.println("main方法开始....");
        String[] strs = {"aaa","23","sfv","dfs3"};
        ExceptionDemo2.print(strs);  //此处出现异常后，程序将终止，后面的代码将不会执行
        System.out.println("main方法结束....");  //不会输出
    }

    public static void print(String[] strs){
        for (int i = 0; i <=strs.length ; i++) {  //正常下标范围 0 ~ 数组.length-1
            System.out.println(strs[i]); // i 0 1 2 3 4  ArrayIndexOutOfBoundsException:4
        }
    }

}

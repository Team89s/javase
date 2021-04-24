package com.igeek.javase.day08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @version 1.0
 * @Description 常规异常处理方式
 * @Author chenmin
 * @Date 2020/11/6 15:38
 *
 * 1.若不是main方法或者界面操作，遇到编译期异常则直接向上抛出
 * 2.当你抛至main方法或界面时，则可直接try...catch捕获处理
 */
public class ExceptionDemo3 {

    public static void work() throws FileNotFoundException {
        System.out.println("work()开始...");
        FileInputStream fis = new FileInputStream("D:\\1.txt");
        System.out.println("work()结束....");
    }

    public static void main(String[] args) {
        try {
            ExceptionDemo3.work();
        } catch (IOException e) {  //catch异常，必须大于等于方法中抛出的异常
            e.printStackTrace();
        } finally {
            System.out.println("资源关闭");
        }
    }

}

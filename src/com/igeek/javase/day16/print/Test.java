package com.igeek.javase.day16.print;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * @version 1.0
 * @Description 测试打印流
 * @Author chenmin
 * @Date 2020/11/25 16:22
 */
public class Test {

    public static void main(String[] args) {

        System.out.println("你好!!!");  //输出到控制台
        try(PrintStream ps = new PrintStream("abc.txt");){
            System.setOut(ps);

            //输出到文本中
            System.out.println("你好");
            System.out.println("哈哈");
            System.out.println("呵呵");
            System.out.println("拜拜");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}

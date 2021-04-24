package com.igeek.javase.day16.print;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * @version 1.0
 * @Description PrintStream 类
 * @Author chenmin
 * @Date 2020/11/25 16:11
 *
 * 打印流
 * PrintStream  字节流   打印流
 *
 * 构造方法：
 *      PrintStream(File file)  创建一个新的打印流，不带自动行刷新，用指定的文件。
 *      PrintStream(File file, String csn) 创建一个新的打印流，无线自动冲洗，用指定的文件和字符集。
 *      PrintStream(OutputStream out) 创建一个新的打印流。
 *      PrintStream(String fileName)  创建一个新的打印流，没有自动行刷新，用指定的文件名。
 *      PrintStream(String fileName, String csn)  创建一个新的打印流，无线自动冲洗，用指定的文件名和字符集。
 */
public class PrintStreamDemo {

    public static void main(String[] args) {
        try (
                PrintStream ps = new PrintStream("abc.txt");
        ){
            ps.println("明天星期四");
            ps.flush();
            System.out.println("写出完成");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}

package com.igeek.javase.day16.buffer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @version 1.0
 * @Description BufferedWriter类
 * @Author chenmin
 * @Date 2020/11/25 14:33
 *
 * 缓冲流（高效流）
 *     缓冲流的基本原理，是在创建流对象时，会创建一个内置的默认大小的缓冲区数组，
 * 通过缓冲区读写，减少系统IO次数，从而提高读写的效率。
 *
 * BufferedWriter  字符流   输出流   处理流
 * 作用：将FileWriter的流传递给效率较高的BufferedWriter进行包装
 *
 * 构造方法
 *      BufferedWriter(Writer out)  创建一个使用默认大小输出缓冲区的缓冲字符输出流。
 * 常用方法
 *      void write(int c)  写一个字符。
 *      void write(char[] cbuf, int off, int len)  写入一个字符数组的一部分。
 *      void write(String s, int off, int len)  写入字符串的一部分。
 *      void write(char[] cbuf)  写一个字符数组。
 *      void write(String str)  写一个字符串。
 *      void newLine()  写行分隔符。
 */
public class BufferedWriterDemo {

    public static void main(String[] args) {

        try (
                FileWriter fw = new FileWriter("test.txt",true);
                BufferedWriter bw = new BufferedWriter(fw);
        ){
            bw.write("你好，好热");
            //换行
            bw.newLine();
            bw.write("你你你，我我我".toCharArray());
            bw.newLine();
            bw.flush();
            System.out.println("写出完成");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

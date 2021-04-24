package com.igeek.javase.day16.buffer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @version 1.0
 * @Description BufferedReader类
 * @Author chenmin
 * @Date 2020/11/25 14:32
 *
 * 缓冲流（高效流）
 *      缓冲流的基本原理，是在创建流对象时，会创建一个内置的默认大小的缓冲区数组，
 * 通过缓冲区读写，减少系统IO次数，从而提高读写的效率。
 *
 * BufferedReader  字符流   输入流    处理流
 * 作用：通过缓冲流可以包装相对来说效率较低的FileReader流
 *
 * 构造方法
 *      BufferedReader(Reader in)  创建一个使用默认大小输入缓冲区的缓冲字符输入流。
 * 常用方法
 *      int read()  读取单个字符。
 *      int read(char[] cbuf) 将字符读入一个数组。
 *      int read(char[] cbuf, int off, int len)  将字符读入一个数组的一部分。
 *      String readLine()  读一行文本。
 *
 * 总结：读文本内容效率高，首先由内置的字符数组缓冲区，大小是8KB，其次本身是字符流
 * 使用频率高
 */
public class BufferedReaderDemo {

    public static void main(String[] args) {

        try (
                FileReader fr = new FileReader("abc.txt");
                BufferedReader br = new BufferedReader(fr);
        )
        {
            //int read()  读取单个字符。
            //int i = br.read();
            //System.out.println((char)i);

            //int read(char[] cbuf, int off, int len)  将字符读入一个数组的一部分。
            //char[] chs = new char[1024];
            //int len = br.read(chs, 0, 10);
            //System.out.println(new String(chs,0,len));

            //String readLine()  读一行文本。
            String str;
            while((str=br.readLine())!=null){
                System.out.println(str);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

package com.igeek.javase.day16.buffer;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @version 1.0
 * @Description BufferedInputStream 类
 * @Author chenmin
 * @Date 2020/11/25 10:59
 *
 * 缓冲流（高效流）
 *      缓冲流的基本原理，是在创建流对象时，会创建一个内置的默认大小的缓冲区数组，
 * 通过缓冲区读写，减少系统IO次数，从而提高读写的效率。
 *
 * BufferedInputStream  字节流  输入流  处理流
 * 作用：将磁盘上的文本内容读入到内存中，创建一个内置的默认大小的缓冲区数组
 *
 * 构造方法：
 *      BufferedInputStream(InputStream in) 创建一个 BufferedInputStream和保存它的参数，输入流 in，供以后使用。
 * 常用方法：
 *      int read()
 *      int read(byte[] b, int off, int len) 从这个字节的输入流读取到指定的字节数组中的字节，从给定的偏移量开始。
 *      int read(byte[] b)
 * 总结：
 *      当你一个个字节读取时，一旦遇到中文，截断，造成中文读出来乱码
 */
public class BufferedInputStreamDemo {

    public static void main(String[] args) {

        try(
                FileInputStream fis = new FileInputStream("abc.txt");
                BufferedInputStream bis = new BufferedInputStream(fis);
        ){

            //读取中文会出现乱码，不建议使用
            //int i1 = bis.read();
            //System.out.println((char)i1);

            byte[] bytes = new byte[1024];
            int len;
            while ((len=bis.read(bytes))!=-1) {
                System.out.println(new String(bytes,0,len));
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }


    }

}

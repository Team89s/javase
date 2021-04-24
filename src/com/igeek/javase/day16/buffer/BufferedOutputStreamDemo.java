package com.igeek.javase.day16.buffer;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @version 1.0
 * @Description BufferedOutputStream类
 * @Author chenmin
 * @Date 2020/11/25 11:00
 *
 * 缓冲流（高效流）
 *     缓冲流的基本原理，是在创建流对象时，会创建一个内置的默认大小的缓冲区数组，
 * 通过缓冲区读写，减少系统IO次数，从而提高读写的效率。
 *
 * BufferedOutputStream  字节流   输出流  处理流
 * 作用：将内存中的文本数据写出到磁盘上，创建一个内置的默认大小的缓冲区数组
 *
 * 构造方法：
 *      BufferedOutputStream(OutputStream out) 创建一个新的缓冲输出流，将数据写入到指定的基本输出流中。
 * 常用方法：
 *       void write(byte[] b)
 *       void write(byte[] b, int off, int len)  写 len字节指定字节数组中的起始偏移 off这个缓冲输出流。
 *       void write(int b)  将指定的字节写入该缓冲输出流中。
 */
public class BufferedOutputStreamDemo {

    public static void main(String[] args) {

        try(
                FileOutputStream fos = new FileOutputStream("abc.txt",true);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
        ){
            bos.write("\r\n".getBytes());
            bos.write(97);
            bos.write("\r\n".getBytes());
            bos.write("午好".getBytes());
            bos.flush();
            System.out.println("写出成功");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

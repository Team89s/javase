package com.igeek.javase.day16.chars;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @version 1.0
 * @Description FileWriter类
 * @Author chenmin
 * @Date 2020/11/25 9:51
 *
 * FileWriter  字符流   输出流   节点流
 * 作用：将文本文件上的内容，以一个个字符或字符数组从内存写出到磁盘上
 *
 * 构造方法：
 *      FileWriter(File file)  构建了一个文件对象FileWriter对象。
 *      FileWriter(File file, boolean append)  构建了一个文件对象FileWriter对象。
 *      FileWriter(String fileName) 构造给定文件名的FileWriter对象。
 *      FileWriter(String fileName, boolean append)  构造FileWriter对象给出一个文件名与一个布尔值，指示是否附加写入的数据。
 *
 * 常用方法：
 *      void write(char[] cbuf)  写一个字符数组。
 *      void write(int c)  写一个字符。
 *      void write(String str)  写一个字符串。
 *      void write(char[] cbuf, int off, int len)  写入一个字符数组的一部分。
 *      void write(String str, int off, int len)  写入字符串的一部分。
 *
 * 总结：
 *        读写文本内容建议使用字符流。字符流读写效率会高于字节流
 *
 *        从内存写出磁盘上时，默认会进行覆盖，若想要追加内容则必须构造方法中添加true；
 *        从内存写出磁盘上时，默认不会换行，若想要换行则需要写出\r\n；
 *        flush() 刷新是确保写出内容可以立即到磁盘上，刷新后仍然可以继续写出
 *        close() 关闭即关闭流资源，关闭后不可以再继续写出
 */
public class FileWriterDemo1 {

    public static void main(String[] args) {
        //通过直接传入文件逻辑名，创建FileWriter的对象
        FileWriter fw = null;
        try {
            fw = new FileWriter("abc.txt");

            //void write(int c)  写一个字符。
            fw.write('a');
            //void write(char[] cbuf)  写一个字符数组。
            fw.write(new char[]{'c','b','a','b'});

            //换行
            fw.write("\r\n");

            //void write(String str)  写一个字符串。
            fw.write("今天又下雨！");

            fw.flush();  //刷新是确保写出内容可以立即到磁盘上，刷新后仍然可以继续写出
            fw.write("闪现1");
            System.out.println("写出成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if(fw!=null){
                try {
                    fw.close();  //关闭即关闭流资源，关闭后不可以再继续写出
                    //fw.write("闪现2");  //java.io.IOException: Stream closed
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

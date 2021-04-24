package com.igeek.javase.day16.outin;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @version 1.0
 * @Description FileOutputStream类
 * @Author chenmin
 * @Date 2020/11/24 16:11
 *
 * FileOutputStream   字节流  输出流  节点流
 * 作用：将内存中的数据写出到磁盘上
 *
 * 1.构造方法
 *      覆盖文本内容
 *          FileOutputStream(File file)
 *          FileOutputStream(String name)
 *
 *      boolean值赋值为true,则直接追加文本内容
 *          FileOutputStream(File file, boolean append)
 *          FileOutputStream(String name, boolean append)
 *
 * 2.常用方法
 *      void close()  关闭此文件输出流并释放与此流关联的任何系统资源。
 *      void write(int b)  将指定的字节写入该文件输出流中。
 *      void write(byte[] b) 写 b.length字节从指定的字节数组来此文件输出流。
 *      void write(byte[] b, int off, int len) 写 len字节指定字节数组中的起始偏移 off此文件输出流。
 *
 * 总结：
 *      write(int b)  若写出的是数字或者英文都是OK的，但是若是中文（写出不全），则会出现乱码
 *      write(byte[] b)  会根据字节数组来写出到文本中，可以解决乱码现象
 *
 *      flush()  刷新流，刷新后仍然可以进行文本的写出操作
 *      close()  关闭流，关闭流后不可以进行文本的写出操作
 *      "\r\n".getBytes()  换行写出
 *      构造方法中添加true的参数  追加写出
 *
 *      字节流并不适合读取文本文件内容输出，读写文本内容建议使用字符流。
 *
 *      造成中文乱码的原因：解码与编码格式不一致
 */
public class FileOutputStreamDemo2 {

    public static void main(String[] args) {
        //1.打开往文本写出内容的流通道
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("abc.txt");

            //2.写出文本内容至磁盘上  write(byte[] b)
            byte[] bytes = {97,98,99};
            fos.write(bytes);

            String str = "今天星期二";
            fos.write(str.getBytes());  //以默认UTF-8（一个字符占3个字节）进行获取字节数
            //fos.write(str.getBytes("GBK"));  //以默认GBK（一个字符占2个字节）进行获取字节数

            //3.刷新之后，仍然可以再次写出
            fos.flush();
            System.out.println("写出成功！");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭资源，不可以再次写出资源
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

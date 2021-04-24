package com.igeek.javase.day16.outin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @version 1.0
 * @Description FileInputStream类
 * @Author chenmin
 * @Date 2020/11/24 15:18
 *
 * FileInputStream  字节流   输入流   节点流
 * 作用：将数据从磁盘上读到内存中
 *
 * 1.构造方法
 *      FileInputStream(File file)
 *      FileInputStream(String name)
 *      当创建流对象，会打开操作指定文件的流通道
 * 2.常用方法 读
 *      int read()  从这个输入流读取一个字节的数据。
 *      int read(byte[] b) 读到 b.length从输入流到字节数组数据字节。
 *      void close()  关闭此文件输入流并释放与流关联的任何系统资源。
 * 3.总结
 *      read() 读取数据时，按照一个一个字节读取内容，效率较低，一旦遇到中文（会截断），将会出现乱码问题
 *      read(byte[] b) 读取数据时，按照指定的字节数组的长度读取内容，不如字符流效率高，无法完全避免中文乱码问题
 *
 *      字节流并不适合读取文本文件内容输出，读写文本内容建议使用字符流。
 */
public class FileInputStreamDemo2 {

    public static void main(String[] args) {
        //1.创建需要操作文件的对象
        File file = new File("abc.txt");

        //2.创建操作文件的流通道
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);

            //3.int read(byte[] b) 将按照指定的字节数组的长度读取内容
            /*byte[] bytes = new byte[3];

            int i1 = fis.read(bytes);
            System.out.println(new String(bytes,0,i1));

            int i2 = fis.read(bytes);
            System.out.println(new String(bytes,0,i2));*/

            //通过指定文件长度作为字节数组长度，可以解决乱码， 但是长度过长会内存溢出
            /*byte[] bytes = new byte[(int)file.length()];
            int i = fis.read(bytes);
            System.out.println(new String(bytes,0,i));*/

            byte[] bytes = new byte[1024];
            int len = 0;
            while((len = fis.read(bytes))!=-1){
                System.out.println(new String(bytes,0,len));
            }

            //readAllBytes  读取所有字节数   JDK9出现
            //byte[] bs = fis.readAllBytes();
            //System.out.println(new String(bs));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            //4.关闭资源
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

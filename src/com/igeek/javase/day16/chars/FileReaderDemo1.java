package com.igeek.javase.day16.chars;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @version 1.0
 * @Description FileReader类
 * @Author chenmin
 * @Date 2020/11/25 9:51
 *
 * FileReader  字符流  输入流  节点流
 * 作用：将文件文本的内容以一个个字符或字符数组的方式读入到内存中
 *
 * 构造方法：
 *      FileReader(File file) 创建一个新的 FileReader，给予 File读。
 *      FileReader(String fileName) 创建一个新的 FileReader，给定要读取的文件的名称。
 * 常用方法：
 *      int read()  读取单个字符。
 *      int read(char[] cbuf)  将字符读入一个数组。
 *      int read(char[] cbuf, int off, int len) 将字符读入一个数组的一部分。
 *
 *  总结：
 *       读写文本内容建议使用字符流。字符流读写效率会高于字节流
 */
public class FileReaderDemo1 {

    public static void main(String[] args) {
        //创建操作文件的对象
        File file = new File("abc.txt");
        //创建FileReader的对象
        FileReader fr = null;
        try {
            fr = new FileReader(file);

            //int read()  读取单个字符。
            int i1 = fr.read();
            System.out.println((char)i1);  //a

            int i2 = fr.read();
            System.out.println((char)i2);  //A

            int i3 = fr.read();
            System.out.println((char)i3);  //为  中文不会出现乱码

            int i4 = fr.read();
            System.out.println(i4);  //-1

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            //关闭资源
            if(fr!=null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}

package com.igeek.javase.day16.transfer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @version 1.0
 * @Description 一旦文件文本是GBK编码，读入到内存时是UTF-8编码，会造成中文乱码
 * @Author chenmin
 * @Date 2020/11/25 15:27
 *
 * 解决方案？ 转换流
 */
public class Test {

    public static void main(String[] args) {
        //默认按照UTF-8读取，但是此时是通过Windows平台新建的记事本，中文编码集按照GBK的标准存储
        //今天 xx xx ---> xxx x 后果：中文乱码，数字和字母正常输出
        try (FileReader fr = new FileReader("C:\\Users\\cp\\Desktop\\test.txt");){
            char[] chs = new char[1024];
            int len;
            while((len=fr.read(chs))!=-1){
                System.out.println(new String(chs,0,len));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}

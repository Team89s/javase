package com.igeek.javase.day16.transfer;

import java.io.*;

/**
 * @version 1.0
 * @Description InputStreamReader类
 * @Author chenmin
 * @Date 2020/11/25 15:36
 *
 * 转换流
 * InputStreamReader 字符流   输入流   处理流
 * 作用：将字节输入流InputStream转换成字符输入流InputStreamReader，解决中文乱码问题
 *
 * 构造方法
 *      InputStreamReader(InputStream in)  创建一个inputstreamreader使用默认字符集。
 *      InputStreamReader(InputStream in, String charsetName)  创建一个inputstreamreader使用指定的字符集。
 */
public class InputStreamReaderDemo {

    public static void main(String[] args) {
        try (
                FileInputStream fr = new FileInputStream("C:\\Users\\cp\\Desktop\\test.txt");
                //使用默认字符集UTF-8
                //InputStreamReader isr = new InputStreamReader(fr);

                //创建一个指定的字符集GBK
                InputStreamReader isr = new InputStreamReader(fr,"GBK");
                BufferedReader br = new BufferedReader(isr);
        ){

            //读取文本
            String str = "";
            while((str = br.readLine())!=null){
                System.out.println(str);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}

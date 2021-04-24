package com.igeek.javase.day16.transfer;

import java.io.*;

/**
 * @version 1.0
 * @Description OutputStreamWriter类
 * @Author chenmin
 * @Date 2020/11/25 15:36
 *
 * 转换流
 * OutputStreamWriter 字符流  输出流  处理流
 * 作用：将字节输出流OutputStream转换成字符输出流OutputStreamWriter，解决中文乱码问题
 *
 * 构造方法
 *      OutputStreamWriter(OutputStream out)  创建一个outputstreamwriter使用默认的字符编码。
 *      OutputStreamWriter(OutputStream out, String charsetName) 创建一个outputstreamwriter使用指定的字符集。
 */
public class OutputStreamWriterDemo {

    public static void main(String[] args) {
        try (
                //true  可以追加文本内容
                FileOutputStream fos = new FileOutputStream("C:\\Users\\cp\\Desktop\\bbb.txt",true);
                //创建一个使用默认的字符编码的转换流对象
                //OutputStreamWriter osw = new OutputStreamWriter(fos);

                //创建一个指定的字符集的转换流对象
                OutputStreamWriter osw = new OutputStreamWriter(fos,"GBK");
                BufferedWriter bw = new BufferedWriter(osw);
        ){

            //给执行的文件中写出信息
            bw.write("已经下课了");
            bw.newLine();
            bw.write("离上课还远么！");
            bw.newLine();

            bw.flush();
            System.out.println("写出完成");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}

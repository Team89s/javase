package com.igeek.javase.day16.outin;

import java.io.*;

/**
 * @version 1.0
 * @Description 文件拷贝
 * @Author chenmin
 * @Date 2020/11/24 16:49
 *
 */
public class CopyFileTest {

    public static void main(String[] args) {

        File source = new File("D:\\aaa\\文本.txt");
        File target = new File("E:\\test.txt");

        //读入：将文件读入到内存中
        FileInputStream fis = null;
        //写出：将文件写出到指定磁盘上
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(source);
            fos = new FileOutputStream(target);

            //边读边写
            byte[] bytes = new byte[1024];
            int len = 0;
            while((len=fis.read(bytes))!=-1){
                fos.write(bytes,0,len);
            }
            System.out.println("拷贝成功！");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流的资源  顺着开，倒着关
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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

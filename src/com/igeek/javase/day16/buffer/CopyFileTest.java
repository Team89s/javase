package com.igeek.javase.day16.buffer;

import java.io.*;

/**
 * @version 1.0
 * @Description 拷贝文件的对比
 * @Author chenmin
 * @Date 2020/11/25 14:14
 *
 * 作业：选择其中最高效的方式完成，文件夹的拷贝
 */
public class CopyFileTest {

    public static void main(String[] args) {
        File srcFile = new File("E:\\2.JavaSE\\6.day14~day16 IO\\视频\\1.内容介绍.mp4");
        File destDir = new File("D:\\aaa");

        //copy1(srcFile,destDir);   太慢了，执行效率极其低
        copy2(srcFile,destDir);   //消耗时间：132
        copy3(srcFile,destDir);   //消耗时间：525
        copy4(srcFile,destDir);   //消耗时间：61
    }

    //通过FileInputStream和FileOutputStream进行一个一个字节读写操作
    public static void copy1(File srcFile , File destDir){
        long l1 = System.currentTimeMillis();
        try(
                FileInputStream fis = new FileInputStream(srcFile);
                FileOutputStream fos = new FileOutputStream(destDir+"\\1.mp4");
        )
        {
            int i;
            while((i=fis.read())!=-1){
                fos.write(i);
            }
            fos.flush();
            long l2 = System.currentTimeMillis();
            System.out.println("通过FileInputStream和FileOutputStream进行一个一个字节拷贝完成，消耗时间："+(l2-l1));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //通过FileInputStream和FileOutputStream进行字节数组读写操作
    public static void copy2(File srcFile , File destDir){
        long l1 = System.currentTimeMillis();
        try(
                FileInputStream fis = new FileInputStream(srcFile);
                FileOutputStream fos = new FileOutputStream(destDir+"\\2.mp4");
        )
        {
            byte[] bytes = new byte[1024];
            int len;
            while ((len=fis.read(bytes))!=-1){
                fos.write(bytes,0,len);
            }
            fos.flush();
            long l2 = System.currentTimeMillis();
            System.out.println("通过FileInputStream和FileOutputStream进行字节数组拷贝完成，消耗时间："+(l2-l1));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //通过BufferedInputStream和BufferedOutputStream进行一个一个字节读写操作
    public static void copy3(File srcFile , File destDir){
        long l1 = System.currentTimeMillis();
        try(
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destDir+"\\3.mp4"));
        )
        {
            int i;
            while((i=bis.read())!=-1){
                bos.write(i);
            }
            bos.flush();
            long l2 = System.currentTimeMillis();
            System.out.println("通过BufferedInputStream和BufferedOutputStream进行一个一个字节拷贝完成，消耗时间："+(l2-l1));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //通过BufferedInputStream和BufferedOutputStream进行字节数组读写操作
    public static void copy4(File srcFile , File destDir){
        long l1 = System.currentTimeMillis();
        try(
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destDir+"\\4.mp4"));
        )
        {
            byte[] bytes = new byte[1024];
            int len;
            while ((len=bis.read(bytes))!=-1){
                bos.write(bytes,0,len);
            }
            bos.flush();
            long l2 = System.currentTimeMillis();
            System.out.println("通过BufferedInputStream和BufferedOutputStream进行字节数组拷贝完成，消耗时间："+(l2-l1));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

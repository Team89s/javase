package com.igeek.javase.day16.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @version 1.0
 * @Description 单个文件的压缩及解压 - 压缩流ZipOutputStream & ZipInputStream
 * @Author chenmin
 * @Date 2020/11/26 15:31
 */
public class SingleZipTest {

    public static void main(String[] args)throws Exception {
        //zip();
        unzip();
    }

    //单个文件压缩  .txt  -->  压缩成.zip格式
    public static void zip() throws Exception{
        //1.先将需要压缩的文件读入至内存中    FileInputStream
        File file = new File("C:\\Users\\cp\\Desktop\\题目.txt");
        FileInputStream fis = new FileInputStream(file);

        //2.将压缩包写出到磁盘上  ZipOutputStream
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("C:\\Users\\cp\\Desktop\\test.zip"));
        zos.putNextEntry(new ZipEntry(file.getName()));
        zos.setComment("single file zip");

        //3.边读边压缩
        int i;
        while((i=fis.read())!=-1){
            zos.write(i);
        }
        zos.flush();

        //4.关闭资源
        zos.close();
        fis.close();
        System.out.println("Single file zip done");
    }


    //压缩包解压单个文件    压缩成.zip格式  -->  .txt
    public static void unzip() throws Exception{
        //1.先将压缩包读入至内存中   ZipInputStream
        ZipInputStream zis = new ZipInputStream(new FileInputStream("D:\\aaa\\2.zip"));
        ZipEntry zipEntry = zis.getNextEntry();
        System.out.println("压缩文件中的文件名称："+zipEntry.getName());  //压缩文件的名称：2.mp4

        //2.将文件写出到磁盘上   FileOutputStream
        //获取压缩文件中的文件名称
        String fileName = zipEntry.getName();
        String last = fileName.substring(fileName.lastIndexOf("."));
        FileOutputStream fos = new FileOutputStream("C:\\Users\\cp\\Desktop\\222"+last);

        //3.边读边写出
        int i;
        while ((i = zis.read())!=-1){
           fos.write(i);
        }

        //4.关闭资源
        fos.close();
        zis.close();
        System.out.println("Single file unzip done");
    }


}

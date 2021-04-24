package com.igeek.javase.day16.zip;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @version 1.0
 * @Description 多个文件的压缩及解压 - 压缩流ZipOutputStream & ZipInputStream
 * @Author chenmin
 * @Date 2020/11/27 11:21
 */
public class MultipleZipTest {

    public static void main(String[] args) throws Exception {
        //zip(new File("D:\\ccc"),new File("C:\\Users\\cp\\Desktop"));
        unzip(new File("C:\\Users\\cp\\Desktop\\ccc.zip"),new File("C:\\Users\\cp\\Desktop"));
    }

    //多个文件压缩  .txt  -->  压缩成.zip格式
    public static void zip(File srcDir,File destDir) throws Exception{
        //1.先将需要压缩的文件读入至内存中    FileInputStream
        FileInputStream fis = null;

        //2.将压缩包写出到磁盘上  ZipOutputStream
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(new File(destDir,srcDir.getName()+".zip")));

        //3.边读边压缩
        int i;
        if(srcDir.isDirectory()) {
            File[] files = srcDir.listFiles();
            for (File f : files) {
                if(f.isFile()){
                    fis = new FileInputStream(f);
                    zos.putNextEntry(new ZipEntry(srcDir.getName()+File.separator+f.getName()));
                    System.out.println("正在压缩"+f.getName());
                    while((i=fis.read())!=-1){
                        zos.write(i);
                    }
                    fis.close();
                }
            }
        }
        zos.setComment("Multiple file zip");
        zos.flush();

        //4.关闭资源
        zos.close();
        System.out.println("Multiple file zip done");
    }


    //压缩包解压多个文件    压缩.zip格式  -->  .txt
    public static void unzip(File srcZipFile,File destDir) throws Exception{
        //1.先将压缩包读入至内存中   ZipInputStream
        InputStream fis = new FileInputStream(srcZipFile);
        ZipInputStream zis = new ZipInputStream(fis);
        //实例化ZipFile对象
        ZipFile zipFile = new ZipFile(srcZipFile);

        //2.将文件写出到磁盘上   FileOutputStream
        FileOutputStream fos = null;
        //定义输出文件路径
        File outFile = null;

        //3.边读边写出
        ZipEntry zipEntry = null;
        //获得压缩实体
        while((zipEntry = zis.getNextEntry())!=null){
            //获取压缩文件中的文件名称
            String fileName = zipEntry.getName();
            System.out.println("解压"+fileName+"文件");
            String last = fileName.substring(fileName.lastIndexOf("."));

            //定义输出文件路径
            outFile = new File(destDir+"\\"+fileName);

            //若输出文件夹不存，则创建
            if(!outFile.getParentFile().exists()){
                outFile.getParentFile().mkdirs();
            }

            if(!outFile.exists()){
                if(zipEntry.isDirectory()){
                    outFile.mkdirs();
                    System.out.println("create dir...");
                }else{
                    outFile.createNewFile();
                    System.out.println("create file...");
                }
            }

            if(!zipEntry.isDirectory()){
                fis = zipFile.getInputStream(zipEntry);
                fos = new FileOutputStream(outFile);
                int i;
                while ((i = fis.read())!=-1){
                    fos.write(i);
                }
                fis.close();
                fos.close();
            }

        }

        //4.关闭资源
        zis.close();
        System.out.println("Single file unzip done");
    }

}

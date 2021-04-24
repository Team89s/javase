package com.igeek.javase.day15.file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @version 1.0
 * @Description File类
 * @Author chenmin
 * @Date 2020/11/23 16:31
 *
 * File类
 * 1.文件或路径对象
 * 2.public File(String pathname)
 * 通过将给定的路径名字符串转换为抽象路径名来创建新的 File实例。
 * 3.File只是操作文件或文件夹本身，并不会对文件内容加以操作
 */
public class FileDemo1 {

    public static void main(String[] args) {
        //创建文件对象 - > 指定的是路径（目录）  绝对路径
        File file1 = new File("E:\\2.JavaSE\\6.day14~day16 IO");
        //File file11 = new File("E:/2.JavaSE/6.day14~day16 IO");

        //创建文件对象 - > 指定的是文件  相对路径，建议使用，直接在项目下创建
        File file2 = new File("abc.txt");

        /**
         * 获取功能方法
         */
        //public String getAbsolutePath()：返回此File的绝对路径名字符串。
        System.out.println("file1的绝对路径："+file1.getAbsolutePath());
        System.out.println("file2的绝对路径："+file2.getAbsolutePath());

        //public String getPath()：将此File转换为路径名字符串。
        System.out.println("file1的路径："+file1.getPath());
        System.out.println("file2的路径："+file2.getPath());

        //public String getName()：返回由此File表示的文件或目录的名称。
        System.out.println("file1的名称："+file1.getName());
        System.out.println("file2的名称："+file2.getName());

        //public long length()：返回由此File表示的文件的长度。
        System.out.println("file1的长度："+file1.length());
        System.out.println("file2的长度："+file2.length());


        /**
         * 判断功能的方法
         */
        //public boolean exists()：此File表示的文件或目录是否实际存在。
        System.out.println(file2.exists());
        System.out.println(file1.exists());

        //public boolean isDirectory()：此File表示的是否为目录。
        //public boolean isFile()：此File表示的是否为文件。
        System.out.println(file1.isFile()); //false
        System.out.println(file2.isFile()); //true
        System.out.println(file1.isDirectory()); //true
        System.out.println(file2.isDirectory()); //false

        //long lastModified() 返回文件的抽象路径名表示上次修改时间。
        long l = file2.lastModified();
        System.out.println(new Date(l));

        /**
         * 创建删除功能的方法
         */
        File file3 = new File("D:\\abc");
        File file4 = new File("D:\\aaa\\bbb");
        File file5 = new File("D:\\aaa\\bbb\\abc.txt");
        //public boolean mkdir()：创建由此File表示的目录。
        if(!file3.exists()){
            //创建目录，要求一定存在父目录
            file3.mkdir();
            System.out.println("file3创建完毕");
        }
        //public boolean mkdirs()：创建由此File表示的目录，包括任何必需但不存在的父目录。
        if(!file4.exists()){
            //创建目录
            file4.mkdirs();
            System.out.println("file4创建完毕");
        }
        //public boolean createNewFile()：当且仅当具有该名称的文件尚不存在时，创建一个新的空文件。
        if(!file5.exists()){
            try {
                file5.createNewFile();
                System.out.println("创建成功");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("创建失败");
            }
        }
        //public boolean delete()：删除由此File表示的文件或目录。
        //delete方法，如果此File表示目录，则目录必须为空才能删除
        System.out.println("删除是否成功："+file3.delete()); //true
        System.out.println("删除是否成功："+file4.delete()); //false
        System.out.println("删除是否成功："+file5.delete()); //true
    }

}

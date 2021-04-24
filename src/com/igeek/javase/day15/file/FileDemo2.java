package com.igeek.javase.day15.file;

import java.io.File;
import java.util.Arrays;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/24 10:12
 */
public class FileDemo2 {

    public static void main(String[] args) {

        File file1 = new File("D:\\aaa");
        File file2 = new File("D:\\aaa\\文本.txt");
        File file3 = new File("D:\\ccc");

        //String[] list() 返回的字符串数组，在该目录下的抽象路径名的文件和目录名。
        if(file1.isDirectory()){
            String[] str1 = file1.list(); //非空目录
            System.out.println(Arrays.toString(str1)); //[bbb, 文本.txt, 新建.docx]
        }

        if(file2.isDirectory()){
            String[] str2 = file2.list();
            System.out.println(Arrays.toString(str2));  //null
        }

        if(file3.isDirectory()){
            String[] str3 = file3.list();  //空目录
            System.out.println(Arrays.toString(str3));  //[]
        }

        //File[] listFiles() 返回表示抽象路径名的文件数组，在该目录下的抽象路径名的文件。
        if(file1.isDirectory()){
            File[] files = file1.listFiles();
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        }
    }

}

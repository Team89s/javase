package com.igeek.javase.day15.file;

import java.io.File;
import java.util.Arrays;
import java.util.Date;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/24 10:12
 */
public class FileDemo4 {

    public static void main(String[] args) {
        File file = new File("D:\\aaa");

        //String[] list(FilenameFilter filter)
        //返回的字符串在该目录下的抽象路径名，满足指定的过滤器表示文件和目录命名数组。
        if(file.isDirectory()){
            String[] strs = file.list(((dir, name) -> name.contains("Test")));
            System.out.println(Arrays.toString(strs));
        }

        System.out.println("---------------------");

        //File[] listFiles(FilenameFilter filter)
        //返回表示的抽象路径名的文件和目录的目录，这个抽象路径名满足指定过滤器表示数组。
        if(file.isDirectory()){
            File[] files = file.listFiles(((dir, name) -> name.contains("Test")));
            for (File f : files){
                System.out.println(new Date(f.lastModified()));
            }
        }

        System.out.println("---------------------");

        //File[] listFiles(FileFilter filter)
        //返回表示的抽象路径名的文件和目录的目录，这个抽象路径名满足指定过滤器表示数组。
        if(file.isDirectory()){
            File[] files = file.listFiles(pathname -> pathname.getName().endsWith(".java"));
            for (File f : files) {
                System.out.println(f.getName());
            }
        }
    }

}
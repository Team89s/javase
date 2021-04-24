package com.igeek.javase.day15.file;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Date;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/24 10:12
 */
public class FileDemo3 {

    public static void main(String[] args) {
        File file = new File("D:\\aaa");

        //String[] list(FilenameFilter filter)
        //返回的字符串在该目录下的抽象路径名，满足指定的过滤器表示文件和目录命名数组。
        if(file.isDirectory()){
            String[] strs = file.list(new MyFilenameFilter("Test"));
            System.out.println(Arrays.toString(strs));
        }

        System.out.println("---------------------");

        //File[] listFiles(FilenameFilter filter)
        //返回表示的抽象路径名的文件和目录的目录，这个抽象路径名满足指定过滤器表示数组。
        if(file.isDirectory()){
            File[] files = file.listFiles(new MyFilenameFilter("Test"));
            for (File f : files){
                System.out.println(new Date(f.lastModified()));
            }
        }

        System.out.println("---------------------");

        //File[] listFiles(FileFilter filter)
        //返回表示的抽象路径名的文件和目录的目录，这个抽象路径名满足指定过滤器表示数组。
        if(file.isDirectory()){
            File[] files = file.listFiles(new MyFileFilter(".java"));
            for (File f : files) {
                System.out.println(f.getName());
            }
        }
    }

}
class MyFilenameFilter implements FilenameFilter {

    private String str;

    public MyFilenameFilter(String str){
        this.str = str;
    }

    /**
     * accept 定义过滤规则
     * @param dir  过滤的目录
     * @param name 过滤的目录下的，所有文件夹及文件
     * @return  true筛选下来的留用的
     */
    @Override
    public boolean accept(File dir, String name) {
        //System.out.println(dir.getAbsolutePath());
        //System.out.println(name);

        if(name.contains(str)){
            return true;
        }
        return false;
    }
}

class MyFileFilter implements FileFilter{

    private String str;

    public MyFileFilter(String str){
        this.str = str;
    }

    /**
     * 定义过滤规则
     * @param pathname  指定的过滤目录下的所有文件对象
     * @return  true留下符合过滤规则的
     */
    @Override
    public boolean accept(File pathname) {
        //System.out.println(pathname.getAbsolutePath());

        if(pathname.getName().endsWith(str)){
            return true;
        }
        return false;
    }
}

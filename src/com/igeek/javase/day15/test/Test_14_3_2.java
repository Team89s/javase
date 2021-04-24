package com.igeek.javase.day15.test;

import java.io.File;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/7 16:32
 *
 * 递归删除
 * 键盘录入一个文件夹路径，删除该路径下的文件夹。
 * 要求：文件夹中包含有子文件夹
 */
public class Test_14_3_2 {

    public static void main(String[] args) {
        File file = new File("D:\\ccc");
        deleteFile(file);
    }

    public static void deleteFile(File file) {
        //不遍历的条件
        if(file==null || !file.exists() || file.isFile() || file.isHidden())  return;

        //进行遍历
        File[] files = file.listFiles();
        for (File f : files) {
            if(f.isHidden()){
                return;
            }else if(f.isFile()){
                //若是文件
                f.delete();
            }else if(f.isDirectory()){
                //若是目录
                deleteFile(f);
            }
        }

        //文件全部删除了，删除其下的文件夹
        for (File f : file.listFiles()) {  //file.listFiles() 是上面递归删除完全的
            System.out.println(f);
            f.delete();
        }
        //删除文件夹  直接将file全部删除
        /* file.delete();*/
    }

}

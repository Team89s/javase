package com.igeek.javase.day15.test;

import java.io.File;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/7 16:19
 *
 * 使用文件过滤器筛选将指定文件夹下的小于200K的小文件获取并打印(包括所有子文件夹的文件)。
 */
public class Test_14_3_1 {

    public static void main(String[] args) {
        File file = new File("D:\\aaa");
        selectFile(file);
    }

    public static void selectFile(File file){
        File[] files = file.listFiles();
        for (File f : files) {
            //未传入文件对象  或者  文件不存在 或者  隐藏文件
            if(f==null || !f.exists() || f.isHidden()){
                return;
            }else if(f.isDirectory()){
                //若是目录，则继续迭代
                selectFile(f);
            }else if(f.isFile()){
                //若是文件，取文件大小进行比较
                if(f.length()/1024<200){
                    System.out.println(f.getName()+" - "+f.length());
                }
            }
        }
    }

}

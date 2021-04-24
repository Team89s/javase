package com.igeek.javase.day16.test;

import java.io.*;

/**
 * @version 1.0
 * @Description 文件夹的拷贝
 * @Author chenmin
 * @Date 2020/11/26 9:20
 *
 * 作业1：选择其中最高效的方式完成，文件夹的拷贝
 */
public class Test1 {

    public static void main(String[] args) {
        File srcDir = new File("D:\\aaa");
        File destDir = new File("E:\\aaa");
        copyDir(srcDir,destDir);
        System.out.println("文件夹拷贝完成");
    }


    /**
     * 文件夹拷贝
     * @param srcDir   源目录
     * @param destDir  目标路径
     */
    public static void copyDir(File srcDir,File destDir){
        if(srcDir!=null && destDir!=null && srcDir.exists() && srcDir.isDirectory()){
            destDir.mkdirs();
            File[] files = srcDir.listFiles();
            //当你没有权限操作此文件夹时，此时返回null；若返回长度为0则说明源目录没有子文件
            if(files!=null && files.length!=0){
                for (File file : files) {
                    if(file.isFile()){  //是文件，直接拷贝
                        copyFile(file,new File(destDir,file.getName()));
                    }else if(file.isDirectory()){  //是目录，继续迭代
                        copyDir(file,new File(destDir,file.getName()));
                    }
                }
            }
        }else{
            System.out.println("源路径不存在");
        }
    }

    /**
     * 拷贝文件
     * @param srcFile   源文件
     * @param destDir   目标路径
     */
    public static void copyFile(File srcFile , File destDir){
        try(
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destDir));
        )
        {
            byte[] bytes = new byte[1024];
            int len;
            while ((len=bis.read(bytes))!=-1){
                bos.write(bytes,0,len);
            }
            bos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

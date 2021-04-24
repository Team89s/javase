package com.igeek.javase.day15.test;

import java.io.*;
import java.util.Scanner;
import java.util.UUID;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/8 10:09
 *
 * 从控制台获取输入的文件目录然后将该目录(包含子目录)下的.java文件复制到D:/java文件夹中,并统计java文件的个数.
 * 提示:如果有相同的名称的文件,如果两个Test01.java,则拷贝到目标文件夹时只能有一个Test01.java,
 * 另一个Test01.java要修改为另一个名称:该名称可随机生成,只要不重复即可.
 */
public class Test_15_3_3 {

    static int count = 0;

    public static void main(String[] args) throws IOException {
        File srcDir = sc();
        File destDir = new File("D:/java");
        if(!destDir.exists()){
            //创建目录
            destDir.mkdirs();
        }
        totalFile(srcDir,destDir);
        System.out.println("java的文件数："+count);
    }

    //从控制台获取输入的文件目录
    public static File sc() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入文件：");
        String fileName = sc.next();
        File file = new File(fileName);
        if(!file.exists()){
           throw new RuntimeException("当前文件目录不存在");
        }
        if(!file.isDirectory()){
            throw new RuntimeException("当前文件不是目录");
        }
        return file;
    }

    /**
     * 拷贝文件
     * @param srcFile   源文件
     * @param destDir   目标路径
     */
    public static void copyFile(File srcFile,File destDir){
        //若传入的源文件名称在拷贝至的路径下已存在，则修改名称
        String oldName = srcFile.getName();
        //创建File对象，是在指定的目标路径下，创建oldName文件
        File newFile = new File(destDir,oldName);
        //已存在
        if(newFile.exists()){
            //新文件名：随机数+源文件的后缀
            newFile = new File(destDir, UUID.randomUUID().toString()+oldName.substring(oldName.lastIndexOf(".")));
        }

        //拷贝
        try(
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newFile));
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

    /**
     * 统计.java文件的个数
     * @param srcDir  源目录
     * @param destDir 目标目录
     */
    public static void totalFile(File srcDir,File destDir){
        if(!srcDir.isDirectory()) return;

        //迭代目录
        File[] files = srcDir.listFiles((pathname) -> {
            //如果迭代出来的是目录 或者 迭代出来的是java文件
            if (pathname.isDirectory() || pathname.getName().endsWith(".java")) {
                return true;
            }
            return false;
        });

        //file对象要么是目录，要么是.java为后缀的文件
        for (File file : files) {
            if(file.isDirectory()){
                totalFile(file,destDir);
            }else{
                //一定是文件，且是.java文件
                count++;
                //拷贝
                copyFile(file,destDir);
            }
        }
    }

}

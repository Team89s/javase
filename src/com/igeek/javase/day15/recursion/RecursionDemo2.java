package com.igeek.javase.day15.recursion;

import java.io.File;
import java.io.IOException;

/**
 * @version 1.0
 * @Description 递归
 * @Author chenmin
 * @Date 2020/11/24 11:13
 *
 * 递归
 *   1.规律性
 *      求1~n的和
 *      求1~n的乘
 *      猴子吃桃子的问题，第一天吃了一半多一个，第二天再吃一半多一个，第10天只剩余1个，请问第一天摘了多少个桃子？
 *
 *   2.非规律性
 *      文件搜索
 *      文件删除
 *      喝啤酒问题，一瓶啤酒2元，两个空瓶子可以换一瓶啤酒，四个啤酒盖可以换一瓶啤酒，请问10元一共可以喝多少瓶？
 *
 * 总结：使用递归，要求必须要有终结点，否则会出现java.lang.StackOverflowError 堆栈溢出错误
 */
public class RecursionDemo2 {

    public static void main(String[] args) {
        File file = new File("D:\\javaTool");
        searchFile(file,"FeiQ.exe");
    }

    /**
     * 文件搜索
     * @param file  将要搜索的目录
     * @param fileName  将要搜索的文件名
     */
    public static void searchFile(File file,String fileName){
        //当前遍历的文件是存在的且是目录
        if(file!=null && file.exists() && file.isDirectory()){

            File[] files = file.listFiles();
            //当前必须是一级目录，且不能为空
            if(files!=null && files.length>0){
                for (File f : files) {
                    if(f.isDirectory()){
                        //若是目录，继续递归迭代
                        searchFile(f,fileName);
                    }else if(f.isFile() && f.getName().contains(fileName)){
                        //若是文件，且是指定的
                        System.out.println(f.getAbsolutePath());
                        //删除
                        //f.delete();
                        //启动运行
                        Runtime runtime = Runtime.getRuntime();
                        try {
                            runtime.exec(f.getAbsolutePath());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}

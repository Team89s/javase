package com.igeek.javase.day15.test;

import java.io.File;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/7 17:00
 *
 * 从键盘接收一个文件夹路径,把文件夹中的所有文件以及文件夹的名字按层级打印
 * 例如:
 * aaa是文件夹,里面有bbb.txt,ccc.txt,ddd.txt这些文件,有eee这样的文件夹,eee中有fff.txt和ggg.txt,打印出层级来
 * 	aaa
 * 		bbb.txt
 * 		ccc.txt
 * 		ddd.txt
 * 		eee
 * 			fff.txt
 * 			ggg.txt
 *
 */
public class Test_14_3_4 {

    public static void main(String[] args) {
        File file = new File("D:\\aaa");
        print(file,0);
    }

    public static void print(File file,int level){
        //制表符控制空格的输出
        for (int i = 0; i < level; i++) {
            System.out.print("\t");
        }
        System.out.println(file.getName());

        if(file.isDirectory()){
            File[] files = file.listFiles();
            for (File f : files) {
                print(f,level+1);
            }
        }
    }
}

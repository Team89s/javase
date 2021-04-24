package com.igeek.javase.day16.commonsio;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * @version 1.0
 * @Description commons-io包
 * @Author chenmin
 * @Date 2020/11/26 16:45
 */
public class Test {

    public static void main(String[] args) throws IOException {

        BufferedReader br = IOUtils.buffer(new FileReader("abc.txt"));
        System.out.println(br.readLine());

        //IOUtils.copy(new FileInputStream("D:\\aaa\\2.mp4"),new FileOutputStream("D:\\ccc\\222.mp4"));
        //System.out.println("文件拷贝完成");

        FileUtils.copyDirectory(new File("D:\\aaa"),new File("D:\\ccc\\ddd"));
        System.out.println("文件夹拷贝完成");
    }

}

package com.igeek.javase.day16.test;

import java.io.*;

/**
 * @version 1.0
 * @Description 作业4：通过控制台输入信息，并存储进文本中
 * @Author chenmin
 * @Date 2020/11/26 10:12
 */
public class Test4 {

    /**
     * 存储文本
     * @param destFile  目标文件
     */
    public static void save1(File destFile){
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter pw = new PrintWriter(destFile);
        ){
            System.out.println("请输入：");
            while (true){
                //一直读取控制台上的文本内容
                String str = br.readLine();
                if (str.equals("exit")){
                    break;
                }
                pw.println(str);
                pw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 存储文本
     * @param destFile  目标文件
     */
    public static void save2(File destFile){
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                PrintStream pw = new PrintStream(destFile);
        ){
            System.out.println("请输入：");
            //改变了系统的输出流方式
            System.setOut(pw);
            while (true){
                //一直读取控制台上的文本内容
                String str = br.readLine();
                if (str.equals("exit")){
                    break;
                }
                //打印输出的信息，会被写出到文本中
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        //save1(new File("abc.txt"));
        save2(new File("abc.txt"));
    }

}

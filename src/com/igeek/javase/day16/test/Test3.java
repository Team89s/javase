package com.igeek.javase.day16.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @version 1.0
 * @Description 作业3：读取与类同级的文件信息“张三#123”，完成用户登录
 * @Author chenmin
 * @Date 2020/11/26 9:54
 */
public class Test3 {

    /**
     * 登录
     * @param username  用户名
     * @param password  密码
     */
    public static void login(String username,String password){
        try (
                //获取与Test3这个类在同级目录下的IO流资源
                InputStream is = Test3.class.getResourceAsStream("user.txt");
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
        ){
            String str;
            //读取文本操作
            while ((str=br.readLine())!=null){
                //类似于“张三#123”，切割字符串
                String[] split = str.split("#");
                //匹配用户名和密码
                if(split[0].equals(username) && split[1].equals(password)){
                    //匹配成功，则提示成功，直接结束
                    System.out.println("登录成功");
                    return;
                }
            }
            //循环完毕文本内容都没有匹配，则提示失败
            System.out.println("登录失败");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        try (
                InputStream in = System.in;
                BufferedReader br = new BufferedReader(new InputStreamReader(in))
        ){
            System.out.print("请输入姓名：");
            String username = br.readLine();
            System.out.print("请输入密码：");
            String password = br.readLine();

            login(username,password);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

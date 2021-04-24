package com.igeek.javase.day15.test;

import java.io.*;
import java.util.Scanner;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/8 9:13
 *
 * 模拟用户登录和注册功能实现。
 * 接收用户输入的用户名和密码，然后和文件中存储的用户名、密码匹配。
 * 如果文件已经存在用户名并且密码也是正确的，提示登录成功，否则提示登录失败。
 * 如果文件中不存在该用户名，则使用该用户名和密码注册一个新的账号，并提示注册成功。
 */
public class Test_15_3_1 {

    public static void main(String[] args) {
        Test_15_3_1 test = new Test_15_3_1();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入姓名：");
        String username = sc.next();
        System.out.println("请输入密码：");
        String password = sc.next();
        test.login(username,password);
    }

    //用户登录
    public void login(String username,String password){
        try (BufferedReader br = new BufferedReader(new FileReader("abc.txt"))){
            String str;
            boolean flag = false;
            boolean b = false;
            while((str=br.readLine())!=null){
                String[] split = str.split("#");
                if(username.equals(split[0])){
                    flag = true;
                    if(password.equals(split[1])){
                        System.out.println("登录成功");
                        b = true;
                        return;
                    }
                }
            }
            if(flag && !b){
                System.out.println("用户名与密码不匹配！");
            }
            if(!flag){
                //用户名是不存在的，注册
                System.out.println("当前输入用户名不存在，将进行注册！");
                regist(username,password);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //注册
    public void regist(String username,String password){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("abc.txt"))){
            bw.write(username);
            bw.write("#");
            bw.write(password);
            //换行
            bw.newLine();
            bw.flush();
            System.out.println("注册成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

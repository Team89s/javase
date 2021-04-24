package com.igeek.javase.day07.test;

import java.util.Scanner;

/**
 * @version 1.0
 * @Description 密码强度校验
 * @Author chenmin
 * @Date 2020/11/6 10:18
 */
public class RegexTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入密码：");
        String pwd = sc.nextLine();

        // .* 代表匹配任意字符的任意位置
        int count = 0;
        if(pwd.matches(".*[0-9].*")){  //若是数字
            count++;
        }
        if(pwd.matches(".*[a-z].*")){  //若是小写字母
            count++;
        }
        if(pwd.matches(".*[A-Z].*")){  //若是大写字母
            count++;
        }
        if(pwd.matches(".*[!@#$%^&*()/-_+\\|?].*")){  //若是特殊字符
            count++;
        }

        if(count==4){
            System.out.println("密码强度为：强");
        }else if(count==3 || count==2){
            System.out.println("密码强度为：中");
        }else{
            System.out.println("密码强度为：弱");
        }
    }

}

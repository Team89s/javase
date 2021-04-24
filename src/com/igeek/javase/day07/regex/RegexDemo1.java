package com.igeek.javase.day07.regex;

import java.util.Scanner;

/**
 * @version 1.0
 * @Description 测试QQ合法性
 * @Author chenmin
 * @Date 2020/11/5 16:08
 */
/*
  需求：下面的程序让用户输入一个QQ号码，
  我们要验证：
	- QQ号码必须是5--15位长度
	- 而且必须全部是数字 0-9
	- 而且首位不能为0
*/
public class RegexDemo1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的QQ:");
        String qq = sc.nextLine();
        //boolean flag = validateQQ(qq);
        boolean flag = validateQQByRegex(qq);
        if(flag){
            System.out.println("当前QQ合法");
        }else{
            System.err.println("当前QQ不合法");
        }
    }

    //不用正则表达式判断QQ合法性
    public static boolean validateQQ(String qq){
        if(qq==null || qq.equals("")){
            return false;
        }
        //不合法
        if(qq.length()<5 || qq.length()>15){
            return false;
        }
        for (int i = 0; i < qq.length(); i++) {
            char ch = qq.charAt(i);
            if(ch<'0' || ch>'9'){
                return false;
            }
        }
        if(qq.charAt(0)=='0'){
            return false;
        }
        //合法
        return true;
    }

    //用正则表达式判断QQ合法性
    public static boolean validateQQByRegex(String qq){
        if(qq==null || qq.equals("")){
            return false;
        }
        //boolean matches(String regex) 告诉是否这个字符串匹配给定 regular expression。
        return qq.matches("[1,9]\\d{4,14}");
    }

}

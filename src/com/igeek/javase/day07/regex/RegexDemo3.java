package com.igeek.javase.day07.regex;

import java.util.Scanner;

/**
 * @version 1.0
 * @Description 校验规则
 * @Author chenmin
 * @Date 2020/11/5 16:08
 */
public class RegexDemo3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入:");
        String value = sc.nextLine();
        //boolean flag = validateEmail(value);
        boolean flag = validatePhone(value);
        if(flag){
            System.out.println("当前合法");
        }else{
            System.err.println("当前不合法");
        }
    }

    /**
     * 校验邮箱
     * 123456@qq.com
     * zhangsan123@163.com
     * chenmin002@igeekhome.com.cn
     */
    public static boolean validateEmail(String email){
        String regex = "\\w{5,}@\\w{2,}(\\.[a-z]{2,}){1,2}";
        return email.matches(regex);
    }

    /**
     * 校验手机号
     * 13911112222
     * 1[3-9]  11位
     */
    public static boolean validatePhone(String phone){
        String regex = "1[3-9]\\d{9}";
        return phone.matches(regex);
    }

}

package com.igeek.javase.day06.test;

import java.util.Scanner;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/9 11:35
 *
 * 编写一个校验用户名的程序,检测键盘录入的用户名是否合法
 * 要求:必须以英文开头,只能包含英文,数字和_;最少6位,做多12位
 */
public class Test1_12 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的用户名：");
        String name = sc.nextLine();

        String regex = "[a-zA-Z]\\w{5,11}";

        boolean matches = name.matches(regex);

        if (matches){
            System.out.println("用户名是对的");
        }else {
            System.out.println("错了");
        }

    }

}

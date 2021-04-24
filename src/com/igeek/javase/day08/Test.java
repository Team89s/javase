package com.igeek.javase.day08;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @version 1.0
 * @Description 异常的处理（捕获）来让程序的健壮性更好
 * @Author chenmin
 * @Date 2020/11/9 9:15
 */
public class Test {

    public static void main(String[] args) {
        while (true){
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入：");
            try {
                //java.util.InputMismatchException  输入不匹配异常
                int i = sc.nextInt();
                System.out.println("i = "+i);
                break;
            }catch (InputMismatchException e){
                System.out.println("输入有误，请准确输入数字");
            }
        }
    }

}

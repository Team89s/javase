package com.igeek.javase.day17.dead;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/1 16:45
 */
public class Test {

    public static void main(String[] args) {

        String a = "今年过年不收礼";
        String b = "收礼只收脑白金";

        new Thread(new MyThread1(a,b)).start();
        new Thread(new MyThread2(a,b)).start();
    }

}

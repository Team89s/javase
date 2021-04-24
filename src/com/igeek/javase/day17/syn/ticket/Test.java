package com.igeek.javase.day17.syn.ticket;

/**
 * @version 1.0
 * @Description 卖票的测试类
 * @Author chenmin
 * @Date 2020/12/1 10:02
 */
public class Test {

    public static void main(String[] args) {
        //共同资源
        Ticket ticket = new Ticket();

        //创建三个线程，并启动线程购买票
        new Thread(ticket,"窗口1").start();
        new Thread(ticket,"窗口2").start();
        new Thread(ticket,"窗口3").start();
    }

}

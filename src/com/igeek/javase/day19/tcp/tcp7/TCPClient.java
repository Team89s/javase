package com.igeek.javase.day19.tcp.tcp7;

import java.io.IOException;
import java.net.Socket;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/9 14:10
 */
public class TCPClient {

    public static void main(String[] args) {
        System.out.println("--------客户端---------");

        ThreadPool pool = new ThreadPool(3,100);
        try {
            //1.创建了套接字
            //192.168.21.2   127.0.0.1   localhost  都是代表本机
            Socket socket = new Socket("192.168.21.2",5566);

            //2.启动读写线程，来进行通信
            pool.execute(new ReadThread(socket));
            pool.execute(new WriteThread(socket));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

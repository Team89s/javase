package com.igeek.javase.day19.tcp.tcp4;

import java.io.IOException;
import java.net.Socket;

/**
 * @version 1.0
 * @Description 客户端
 * @Author chenmin
 * @Date 2020/12/9 9:33
 */
public class TCPClient {

    public static void main(String[] args) {
        System.out.println("---------客户端------------");

        try{
            //1.创建Socket套接字   "127.0.0.1"服务端所在的IP  7788服务端注册的端口号
            Socket socket = new Socket("127.0.0.1",7788);

            //2.开启读、写线程
            new ReadThread(socket).start();
            new WriteThread(socket).start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

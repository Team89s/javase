package com.igeek.javase.day19.tcp.tcp4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @version 1.0
 * @Description 服务端
 * @Author chenmin
 * @Date 2020/12/9 9:33
 *
 *需求4：服务端可以接收多条消息，也可以发送消息；
 *      客户端可以发送多条消息，也可以接收消息  （一对一，非阻塞的现象）
 */
public class TCPServer {

    public static void main(String[] args) {
        System.out.println("---------服务端------------");

        try {
            //1.创建服务端的套接字，注册端口号
            ServerSocket ss = new ServerSocket(7788);

            //2.等待接收客户端的接入
            Socket socket = ss.accept();
            System.out.println("客户端成功接入");

            //3.开启读、写线程
            new ReadThread(socket).start();
            new WriteThread(socket).start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

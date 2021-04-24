package com.igeek.javase.day19.tcp.tcp6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/9 14:09
 *
 * 需求6：当服务器只是读取信息，客户端写出信息，
 * 此时一个服务器可以接收多个客户端（采用的策略：服务端为每个接入成功的客户端，让线程池中的一条线程去进行维护之间的管道通信）
 *
 * 采用的策略：服务端为每个接入成功的客户端，让线程池中的一条线程去进行处理与客户端之间的消息通信
 * 优势：不会引起系统的死机，可以控制并发线程的数量
 * 弊端：同时可以并发的线程将受限制，可能会造成大量任务堆积在阻塞任务队列中
 *
 */
public class TCPServer {

    public static void main(String[] args) {
        System.out.println("-------服务端-------");
        //创建自定义的线程池
        ThreadPool pool = new ThreadPool(5,50);
        try {
            //1.创建服务端的套接字
            ServerSocket ss = new ServerSocket(5566);

            //2.等待客户端接入，搭建起来通信管道
            while (true){
                Socket socket = ss.accept();
                System.out.println(socket.getRemoteSocketAddress()+"已上线");

                //3.读取客户端发来的消息
                pool.execute(new ReadThread(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

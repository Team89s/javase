package com.igeek.javase.day19.tcp.tcp5;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/9 14:09
 *
 * 需求5：当服务器只是读取信息，客户端写出信息，
 * 此时一个服务器可以接收多个客户端（采用的策略：服务端为每个接入成功的客户端，创建一条独立的线程去进行维护之间的管道通信）
 *
 * 采用的策略：客户端与服务端的线程模型是N-N的关系，一个客户端需要一个线程
 * 弊端：并发越高，系统瘫痪的越快
 * 解决方案：在服务端引入线程池，使用线程池来处理与客户端的消息通信，
 * 线程池不会引起出现过多的线程而导致系统死机。
 *
 */
public class TCPServer {

    public static void main(String[] args) {
        System.out.println("-------服务端-------");
        try {
            //1.创建服务端的套接字
            ServerSocket ss = new ServerSocket(5566);

            //2.等待客户端接入，搭建起来通信管道
            while (true){
                Socket socket = ss.accept();
                System.out.println(socket.getRemoteSocketAddress()+"已上线");

                //3.读取客户端发来的消息
                new Thread(new ReadThread(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

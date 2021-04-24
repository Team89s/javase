package com.igeek.javase.day19.tcp.tcp7;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @version 1.0
 * @Description 服务端转发消息
 * @Author chenmin
 * @Date 2020/12/9 14:09
 *
 * 需求7：客户端写出信息，此时服务器转发信息给其它客户端，其它客户端读取消息
 */
public class TCPServer {

    public static void main(String[] args) {
        System.out.println("-------服务端-------");

        try {
            //1.创建服务端的套接字
            ServerSocket ss = new ServerSocket(5566);
            //将“话务员”Tasker，存入集合容器中
            CopyOnWriteArrayList<Tasker> list = new CopyOnWriteArrayList();
            //自定义线程池
            ThreadPool pool = new ThreadPool(3,100);

            //2.等待客户端接入，搭建起来通信管道
            while (true){
                Socket socket = ss.accept();

                //3.转发消息
                //每接入一个客户端，就为其创建一个Tasker“话务员”，由话务员来进行转发消息
                Tasker tasker = new Tasker(socket,list);
                list.add(tasker);
                System.out.println(socket.getRemoteSocketAddress()+"已上线");
                pool.execute(tasker);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

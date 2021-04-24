package com.igeek.javase.day20.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @version 1.0
 * @Description BioServer 服务端
 * @Author chenmin
 * @Date 2020/12/10 15:02
 *
 * 1）、使用BIO模型编写一个服务器端，监听6666端口，当有客户端连接时，就启动一个线程与之通信。
 *
 * 2）、要求使用线程池机制改善，可以连接多个客户端。
 *
 * 3）、服务器端可以接收客户端发送的数据（也可使用telnet方式，则无需再编写客户端）
 */
public class BioServer {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();

        try {
            //1.用BIO模型编写一个服务器端，监听6666端口
            ServerSocket ss = new ServerSocket(6666);
            System.out.println("-----服务器启动-----");

            //2.当有客户端连接时，就启动一个线程与之通信。
            while (true){
                //accept() 接收客户端  阻塞点
                System.out.println("test:"+Thread.currentThread().getId()
                        +" : "+Thread.currentThread().getName());
                Socket socket = ss.accept();
                System.out.println("客户端接入成功");
                pool.execute(()->{
                    try {
                        //3.服务器端可以接收客户端发送的数据
                        InputStream is = socket.getInputStream();
                        byte[] bytes = new byte[1024];
                        int i= is.read(bytes);
                        while(i!=-1){
                            System.out.println(new String(bytes,0,i));
                            //read() 读操作  阻塞点
                            System.out.println("test:"+Thread.currentThread().getId()
                                    +" : "+Thread.currentThread().getName());
                            i= is.read(bytes);
                            System.out.println("read....");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.igeek.javase.day19.bs;

import com.igeek.javase.day19.tcp.tcp7.ThreadPool;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @version 1.0
 * @Description 模拟B/S结构的服务器
 * @Author chenmin
 * @Date 2020/12/10 11:20
 *
 * B/S  ->  Browser浏览器/Server服务端
 */
public class BSServer {

    public static void main(String[] args) {
        try {
            //创建服务套接字，注册端口号，接收客户端
            ServerSocket ss = new ServerSocket(7788);
            System.out.println("服务器已开启");
            ThreadPool pool = new ThreadPool(5,50);

            while (true){
                //已经接入客户端
                Socket socket = ss.accept();
                System.out.println("已经接入客户端");

                //从线程池中拿取线程执行任务
                pool.execute(()->{
                    //执行的任务，响应一个页面给客户
                    try {
                        //创建输出的IO流
                        PrintStream ps = new PrintStream(socket.getOutputStream());
                        //写回遵循的协议 HTTP  网页传输协议
                        ps.println("HTTP/1.1 200 OK");
                        //写回响应文本的内容text/html，指定编码集中文友好UTF-8
                        ps.println("Content-Type:text/html;charset=utf-8");
                        //写回响应的空行
                        ps.println();
                        //写回响应正文
                        ps.println("<h1 style='color:red'>写成功啦！！！</h1>");
                        ps.println("<ul><li>111</li><li>222</li><li>333</li></ul>");
                        ps.flush();
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

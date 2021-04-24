package com.igeek.javase.day19.tcp.tcp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @version 1.0
 * @Description 服务端
 * @Author chenmin
 * @Date 2020/12/9 9:33
 *
 * class ServerSocket implements Closeable   ServerSocket资源类
 *
 *需求1：服务端接收一条消息，客户端发送一条消息
 *
 * 服务端步骤：
 * 1.创建服务端的套接字ServerSocket，注册端口号
 * 2.等待接入客户端 accept()
 * 3.通过Socket套接字，获得输入字节流getInputStream()，来进行读取消息
 * 4.通过流对象，读入消息
 */
public class TCPServer {

    public static void main(String[] args) {
        System.out.println("---------服务端------------");

        try (
                //1.创建服务端的套接字，注册端口号
                ServerSocket ss = new ServerSocket(7788);
                //2.等待接收客户端的接入
                Socket socket = ss.accept();
                //3.通过Socket套接字，获得输入字节流，来进行读取消息
                InputStream inputStream = socket.getInputStream();
                //创建了一个转换流
                InputStreamReader reader = new InputStreamReader(inputStream);
                //创建高效流
                BufferedReader br = new BufferedReader(reader);
        ){
            System.out.println("客户端成功接入");
            //服务端读取消息
            String s = br.readLine();
            //socket.getRemoteSocketAddress() 获得当前接入的客户端的IP地址对象
            System.out.println(socket.getRemoteSocketAddress()+"说："+s);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

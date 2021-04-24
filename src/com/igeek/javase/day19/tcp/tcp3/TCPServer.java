package com.igeek.javase.day19.tcp.tcp3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @version 1.0
 * @Description 服务端
 * @Author chenmin
 * @Date 2020/12/9 9:33
 *
 * class ServerSocket implements Closeable   ServerSocket资源类
 *
 *需求3：服务端可以接收多条消息，也可以发送消息；
 *      客户端可以发送多条消息，也可以接收消息  （一对一，阻塞的现象）
 *
 * 服务端步骤：
 * 1.创建服务端的套接字ServerSocket，注册端口号
 * 2.等待接入客户端 accept()
 * 3.通过Socket套接字，获得输入字节流getInputStream()，来进行读取消息
 * 4.通过流对象，读入消息
 * 5.通过流对象，写出消息
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
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                //4.通过Socket套接字，获得输出字节流，来进行写出消息
                PrintWriter pw = new PrintWriter(socket.getOutputStream());
                Scanner sc = new Scanner(System.in);
        ){
            System.out.println("客户端成功接入");

            //服务端先读消息，再写消息
            while (true){
                //读消息
                String str = br.readLine();
                System.out.println(socket.getRemoteSocketAddress()+"说："+str);

                //发消息
                System.out.print("请说：");
                String s = sc.nextLine();
                pw.println(s);
                pw.flush();

                if(s.equals("bye")){
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

package com.igeek.javase.day19.tcp.tcp1;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @version 1.0
 * @Description 客户端
 * @Author chenmin
 * @Date 2020/12/9 9:33
 *
 * class Socket implements Closeable  Socket资源类
 *
 * 客户端步骤：
 * 1.创建Socket套接字
 * 2.通过Socket套接字，获得输出字节流getOutputStream()，来进行写出消息
 * 3.通过流对象，写出消息
 */
public class TCPClient {

    public static void main(String[] args) {
        System.out.println("---------客户端------------");

        try (
                //1.创建Socket套接字
                Socket socket = new Socket("127.0.0.1",7788);
                //2.通过Socket套接字，获得输出字节流，来进行写出消息
                OutputStream outputStream = socket.getOutputStream();
                //创建高效流
                PrintWriter pw = new PrintWriter(outputStream);
        ){
            //客户端发送一条消息
            pw.println("早晨好，吃饭了么？");
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

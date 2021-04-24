package com.igeek.javase.day19.tcp.tcp5;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/9 14:10
 */
public class TCPClient {

    public static void main(String[] args) {
        System.out.println("--------客户端---------");

        try {
            //1.创建了套接字
            //192.168.21.2   127.0.0.1   localhost  都是代表本机
            Socket socket = new Socket("192.168.21.2",5566);

            //2.写出信息
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            Scanner sc = new Scanner(System.in);
            while (true){
                String s = sc.nextLine();

                if(s.equals("exit")){
                    break;
                }
                pw.println(s);
                pw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

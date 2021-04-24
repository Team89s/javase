package com.igeek.javase.day19.tcp.tcp3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @version 1.0
 * @Description 客户端
 * @Author chenmin
 * @Date 2020/12/9 9:33
 *
 * 客户端步骤：
 * 1.创建Socket套接字
 * 2.通过Socket套接字，获得输出字节流getOutputStream()，来进行写出消息
 * 3.通过流对象，写出消息
 * 4.通过流对象，读入消息
 */
public class TCPClient {

    public static void main(String[] args) {
        System.out.println("---------客户端------------");

        try (
                //1.创建Socket套接字
                Socket socket = new Socket("127.0.0.1",7788);

                //2.通过Socket套接字，获得输出字节流，来进行写出消息
                PrintWriter pw = new PrintWriter(socket.getOutputStream());
                Scanner sc = new Scanner(System.in);

                //3.通过Socket套接字，获得输入字节流，来进行读取消息
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ){
            //客户端先发消息，再读消息
            while (true){
                //发消息
                System.out.print("请说：");
                String s = sc.nextLine();
                pw.println(s);
                pw.flush();

                if(s.equals("bye")){
                    break;
                }

                //读消息
                String str = br.readLine();
                System.out.println(socket.getRemoteSocketAddress()+"说："+str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

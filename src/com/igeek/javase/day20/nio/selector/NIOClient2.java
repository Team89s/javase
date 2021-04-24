package com.igeek.javase.day20.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * @version 1.0
 * @Description 客户端
 * @Author chenmin
 * @Date 2020/12/14 13:59
 */
public class NIOClient2 {

    public static void main(String[] args) throws IOException {
        //获取客户端的通信管道
        SocketChannel socketChannel = SocketChannel.open();
        //将客户端的通信管道设置为非阻塞
        socketChannel.configureBlocking(false);
        //提供服务器端的地址
        InetSocketAddress address = new InetSocketAddress("127.0.0.1",7788);

        //判定是否连接成功
        if(!socketChannel.connect(address)){
            //若未连接成功，判断是否完成连接
            while(!socketChannel.finishConnect()){
                //未完成连接
                System.out.println("连接耗时，客户端可以做其它工作，不会阻塞...");
            }
        }

        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.print("请输入：");
            String str = sc.next();
            //将数据包装进缓冲区
            ByteBuffer buffer = ByteBuffer.wrap(str.getBytes());
            //将数据从缓冲区写至通信管道
            socketChannel.write(buffer);

            //客户端退出
            if(str.equals("exit")){
                System.exit(0);
            }
        }
    }

}

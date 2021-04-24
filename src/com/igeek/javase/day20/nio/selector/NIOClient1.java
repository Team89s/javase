package com.igeek.javase.day20.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @version 1.0
 * @Description 客户端
 * @Author chenmin
 * @Date 2020/12/14 13:59
 *
 * SocketChannel，网络 IO 通道，具体负责进行读写操作。
 * NIO 把缓冲区的数据写入通道，或者把通道里的数据读到缓冲区。
 */
public class NIOClient1 {

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

        String str = "hello world";
        byte[] bytes = str.getBytes();
        //创建字节缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
        //将数据添加至缓冲区
        buffer.put(bytes);
        //转换读取方向
        buffer.flip();
        //将数据从缓冲区写至通信管道
        socketChannel.write(buffer);
        //只读一次
        System.in.read();
    }

}

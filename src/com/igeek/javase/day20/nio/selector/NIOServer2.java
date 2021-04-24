package com.igeek.javase.day20.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @version 1.0
 * @Description 服务器端
 * @Author chenmin
 * @Date 2020/12/14 13:59
 *
 * 需求2：服务器可以无限接入客户端，客户端可以无限制写消息，服务端读消息
 */
public class NIOServer2 {

    public static void main(String[] args) throws IOException {

        //1.先创建ServerSocketChannel服务端的通信管道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //2.注册端口号
        serverSocketChannel.socket().bind(new InetSocketAddress(7788));
        //3.将当前服务端通信管道设置为非阻塞
        serverSocketChannel.configureBlocking(false);

        //4.创建Selector选择器（多路复用器）
        Selector selector = Selector.open();
        //5.将服务端注册到选择器，注册的事件是OP_ACCEPT，关注客户端是否接入
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        //6.循环接入客户端
        while (true){
            //模拟轮询
            if(selector.select(1000)==0){
                continue;
            }

            //>0 一定是有注册时关注的事件发生的
            //7.通过选择器，获得SelectionKey的集合，已触发事件的对应的SelectionKey
            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            //通过iterator()获取SelectionKey的迭代器
            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            while(iterator.hasNext()){
                //迭代出已触发的事件
                SelectionKey selectionKey = iterator.next();

                //判定当前事件是客户端接入
                if(selectionKey.isAcceptable()){
                    //通过服务端获取客户端的通道
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    System.out.println("客户端接入成功...");
                    //将客户端的通信管道设置为非阻塞
                    socketChannel.configureBlocking(false);
                    //将客户端注册至选择器上，关注的事件为读数据
                    //第一个参数：选择器，第二个参数：此时关注的事件OP_READ读数据，第三个参数：读数据需要操作的缓冲区
                    socketChannel.register(selector,SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }

                //判定当前事件是读数据
                if(selectionKey.isReadable()){
                    //通过SelectionKey反向获取客户端的通道
                    SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
                    //通过SelectionKey反向获取注册的缓冲区
                    ByteBuffer buffer = (ByteBuffer)selectionKey.attachment();

                    //清空缓冲区
                    buffer.clear();

                    try{
                        //读取数据至注册的缓冲中
                        int read = socketChannel.read(buffer);

                        if(read!=-1){ //客户端还在写消息，服务端继续读取消息
                            System.out.println(socketChannel.getRemoteAddress()+"说："+new String(buffer.array(),0,read));
                        }
                    }catch (IOException e){
                        //客户端退出了，服务端提示此客户端下线消息，并关闭客户端
                        System.out.println(socketChannel.getRemoteAddress()+"下线！");
                        socketChannel.close();
                    }

                }

                //将当前的selectionKey移除，避免重复执行
                iterator.remove();
            }

        }
    }

}

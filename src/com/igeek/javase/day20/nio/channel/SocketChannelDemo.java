package com.igeek.javase.day20.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * @version 1.0
 * @Description 网络通道
 * @Author chenmin
 * @Date 2020/12/11 16:25
 *
 * 聚合Gathering：在将数据读出到buffer中时，可以采用buffer数组，依次读入，一个buffer满了就读下一个。
 * 分散Scattering：在将数据写入到buffer中时，可以采用buffer数组，依次写入，一个buffer满了就写下一个。
 */
public class SocketChannelDemo {

    public static void main(String[] args) {

        try {
            //创建服务端
            ServerSocketChannel serverChannel = ServerSocketChannel.open();
            //服务端注册端口号
            serverChannel.socket().bind(new InetSocketAddress(8888));
            //服务端接入客户端
            SocketChannel clientChannel = serverChannel.accept();

            //ByteBuffer 字节缓冲区的数组
            ByteBuffer[] buffers = new ByteBuffer[2];
            buffers[0] = ByteBuffer.allocate(5);
            buffers[1] = ByteBuffer.allocate(3);

            int maxLength = 8;  //5+3  8个字节指的是字节缓冲区的数组中，各个数组的长度之和

            while (true){
                //统计读取的字节个数
                int r = 0;
                while (r<maxLength){
                    //读：将客户端发送的消息读至缓冲区中
                    long i = clientChannel.read(buffers);
                    r+=i;
                    System.out.println("r = "+r);
                    //输出position、limit
                    Arrays.stream(buffers)
                            .map(buffer->"position = "+buffer.position()+" , limit = "+buffer.limit())
                                .forEach(System.out::println);
                }

                //转换读写
                Arrays.stream(buffers).forEach(buffer->buffer.flip());   //telnet 127.0.0.1 8888

                //统计读取的字节个数
                int w = 0;
                while (w<maxLength){
                    //写：将缓冲区中的数据写回客户端
                    long j = clientChannel.write(buffers);
                    w+=j;
                }

                //清空状态
                Arrays.stream(buffers).forEach(buffer->buffer.clear());

                System.out.println("--------------------");
                System.out.println("r = "+r+", w = "+w+" , maxLength = "+maxLength);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

package com.igeek.javase.day19.udp;

import java.io.IOException;
import java.net.*;

/**
 * @version 1.0
 * @Description UDPClient  发送端，发送数据
 * @Author chenmin
 * @Date 2020/12/8 16:23
 */
public class UDPClient {

    public static void main(String[] args) {
        System.out.println("----------UDPClient 发送端-----------");
        String str = "快下课了，好饿！！！";
        byte[] bytes = str.getBytes();

        //创建发送端的通信对象DatagramSocket，系统会随机分配一个端口号。
        try (DatagramSocket socket = new DatagramSocket()){
            /**
             * 创建发送的数据包
             * byte[]  发送的数据
             * length  发送数据的长度
             * IP      接收端的IP
             * 端口号   接收端的端口号
             */
            DatagramPacket dp = new DatagramPacket(bytes,bytes.length, InetAddress.getLocalHost(),7788);

            //发送数据包
            socket.send(dp);
        } catch (UnknownHostException | SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

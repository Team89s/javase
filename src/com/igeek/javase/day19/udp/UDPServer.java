package com.igeek.javase.day19.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @version 1.0
 * @Description UDPServer  接收端，接收数据
 * @Author chenmin
 * @Date 2020/12/8 16:23
 *
 * UDP协议的特点
 *    1.面向无连接的协议
 *    2.发送端只管发送，不确认对方是否能收到。
 *    3.基于数据包进行数据传输。
 *    4.送数据的大小限制64K以内
 *    5.因为面向无连接，速度快，但是不可靠。
 *
 * UDP协议的使用场景
 *    1.即时通讯
 *    2.在线视频
 *    3.网络语音电话
 *
 * UDP协议相关的两个类
 *     DatagramPacket 数据包对象
 *         作用：用来封装要发送或要接收的数据，比如：集装箱
 *     DatagramSocket 发送/接收对象
 *         作用：用来发送或接收数据包，比如：码头
 */
public class UDPServer {

    public static void main(String[] args) {
        System.out.println("----------UDPServer 接收端-----------");
        byte[] bytes = new byte[1024*64];

        //创建接收端的通信对象DatagramSocket，并指定端口号
        try (DatagramSocket ds = new DatagramSocket(7788)){

            //创建数据包，来接收数据
            /**
             * 创建接收端的数据包对象
             * 第一个参数 buf：用来存储接收到内容
             * 第二个参数 length：能够接收内容的长度
             */
            DatagramPacket dp = new DatagramPacket(bytes,bytes.length);

            //接收数据包
            ds.receive(dp);

            //查看数据
            //getLength() 获得实际接收到的字节个数
            //getData()   获得实际接收到的数据
            System.out.println(new String(dp.getData(),0,dp.getLength()));

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

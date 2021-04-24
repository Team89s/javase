package com.igeek.javase.day19;

import java.io.IOException;
import java.net.InetAddress;

/**
 * @version 1.0
 * @Description InetAddress类
 * @Author chenmin
 * @Date 2020/12/8 16:12
 *
 * InetAddress类  一个该类的对象就代表一个IP地址对象。
 * 常用方法：
 *      //获得本地主机IP地址对象
 *      static InetAddress getLocalHost()
 *
 *      //根据IP地址字符串或主机名获得对应的IP地址对象
 *      static InetAddress getByName(String host)
 *
 *      //获得主机名
 *      String getHostName()
 *
 *      //获得IP地址字符串
 *      String getHostAddress()
 */
public class InetAddressDemo {

    public static void main(String[] args) throws IOException {
        //获得本地主机IP地址对象
        InetAddress host = InetAddress.getLocalHost();
        System.out.println(host);
        System.out.println("主机名:"+host.getHostName());
        System.out.println("IP地址:"+host.getHostAddress());

        //根据IP地址字符串或主机名获得对应的IP地址对象
        System.out.println("-----------------------------");
        InetAddress host1 = InetAddress.getByName("CM");
        System.out.println(host1);
        System.out.println("主机名:"+host1.getHostName());
        System.out.println("IP地址:"+host1.getHostAddress());

        System.out.println("-----------------------------");
        InetAddress host2 = InetAddress.getByName("www.baidu.com");
        System.out.println(host2);
        System.out.println("主机名:"+host2.getHostName());
        System.out.println("IP地址:"+host2.getHostAddress());  //180.101.49.11

        System.out.println("-----------------------------");
        InetAddress host3 = InetAddress.getByName("180.101.49.11");
        System.out.println(host3);
        System.out.println("主机名:"+host3.getHostName());
        System.out.println("IP地址:"+host3.getHostAddress());  //180.101.49.11

        System.out.println("--------------ping---------------");
        //查看是否能ping通百度，返回true则ping通
        System.out.println(host2.isReachable(5000));
    }

}

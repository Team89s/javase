package com.igeek.javase.day19.tcp.tcp2;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @version 1.0
 * @Description 客户端
 * @Author chenmin
 * @Date 2020/12/9 9:33
 *
 * TCP ==> Transfer Control Protocol ==> 传输控制协议
 * TCP协议的特点
 *     * 面向连接的协议
 *     * 只能由客户端主动发送数据给服务器端，服务器端接收到数据之后，可以给客户端响应数据。
 *     * 通过三次握手建立连接，连接成功形成数据传输通道。
 *     * 通过四次挥手断开连接
 *     * 基于IO流进行数据传输
 *     * 传输数据大小没有限制
 *     * 因为面向连接的协议，速度慢，但是是可靠的协议。
 *
 * TCP协议的使用场景
 *     * 文件上传和下载
 *     * 邮件发送和接收
 *     * 远程登录
 *
 * TCP协议相关的类
 *     * Socket
 *         * 一个该类的对象就代表一个客户端程序。
 *     * ServerSocket
 *         * 一个该类的对象就代表一个服务器端程序。
 *
 * Socket类构造方法
 *     * Socket(String host, int port)
 *         * 根据ip地址字符串和端口号创建客户端Socket对象
 *         * 注意事项：只要执行该方法，就会立即连接指定的服务器程序，如果连接不成功，则会抛出异常。
 *             如果连接成功，则表示三次握手通过。
 *
 * Socket类常用方法
 *     * OutputStream getOutputStream(); 获得字节输出流对象
 *     * InputStream getInputStream();获得字节输入流对象
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
                Scanner sc = new Scanner(System.in);
        ){
            //客户端发送多条消息
            System.out.print("请说：");
            String s = sc.nextLine();
            while (s!=null){
                pw.println(s);
                pw.flush();

                if(s.equals("bye")){
                    break;
                }
                System.out.print("请说：");
                s = sc.nextLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

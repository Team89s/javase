package com.igeek.javase.day19.upload;

import java.io.*;
import java.net.Socket;

/**
 * @version 1.0
 * @Description 图片上传
 * @Author chenmin
 * @Date 2020/12/10 9:44
 */
public class UploadClient {

    public static void main(String[] args) throws IOException {
        System.out.println("----------客户端-----------");

        //1.将图片信息读取到内存中
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\aaa\\0.jpg"));

        //2.通过通信管道Socket，写出至服务器端
        //创建Socket套接字，创建客户端
        Socket socket = new Socket("127.0.0.1",8888);

        //通过socket的对象，创建将图片信息写出至服务端的流对象
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());

        //边读边写：（复制）
        byte[] bytes = new byte[1024];
        int i=0;
        while((i=bis.read(bytes))!=-1){
            bos.write(bytes,0,i);
        }
        bos.flush();
        bis.close();
        //发送一个信号 - 告知服务器端已写完
        socket.shutdownOutput();
        System.out.println("客户端上传图片....");

        //6.读取图片上传成功的消息
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = br.readLine();
        System.out.println(s);
    }

}

package com.igeek.javase.day19.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

/**
 * @version 1.0
 * @Description 图片上传
 * @Author chenmin
 * @Date 2020/12/10 9:44
 */
public class UploadServer {

    public static void main(String[] args) throws IOException {
        //创建线程池
        ThreadPool pool = new ThreadPool(5,50);

        //获得服务套接字，注册端口号
        ServerSocket ss = new ServerSocket(8888);
        System.out.println("-----服务器启动-----");
        //接收客户端
        while (true){
            Socket socket = ss.accept();
            System.out.println("已经成功接入客户端");
            pool.execute(new MyRun(socket));
        }
    }

}
class MyRun implements Runnable{
    private Socket socket;
    public MyRun(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //3.先将图片信息通过通信管道Socket，从客户端读到服务端
            BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());

            //4.将图片写出至服务器所在的本地磁盘上
            BufferedOutputStream bos = new BufferedOutputStream(
                    new FileOutputStream(new File("E:\\abc", UUID.randomUUID().toString()+".jpg")));
            //边读边写：（复制）
            byte[] bytes = new byte[1024];
            int i=0;
            while((i=bis.read(bytes))!=-1){
                bos.write(bytes,0,i);
            }
            bos.flush();
            bos.close();

            //5.给客户端写回一个上传完成的信息
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            pw.println("上传完成~~~");
            pw.flush();

        } catch (IOException e) {
            System.out.println("拜拜嘞");
        }
    }
}

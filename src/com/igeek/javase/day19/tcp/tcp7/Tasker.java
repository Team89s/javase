package com.igeek.javase.day19.tcp.tcp7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/9 16:37
 */
public class Tasker implements Runnable {
    private Socket socket;
    private CopyOnWriteArrayList<Tasker> list;
    private BufferedReader br;
    private PrintWriter self; //给自己发消息
    private PrintWriter other; //给其他人发消息

    public Tasker(Socket socket,CopyOnWriteArrayList<Tasker> list){
        this.socket = socket;
        this.list = list;
    }

    @Override
    public void run() {
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String str = null;
            while((str = br.readLine())!=null){
                if(str.equals("exit")){
                    //若自己要退出，迭代遍历所有在线的客户端对应的"话务员"
                    for (Tasker tasker : list) {
                        if(tasker!=this){
                            //给除了自己以外的其他人发消息   tasker.socket其他人的管道   this.socket自己的管道
                            other = new PrintWriter(tasker.socket.getOutputStream());
                            other.println(this.socket.getRemoteSocketAddress()+"已下线！！！");
                            other.flush();
                        }/*else{
                            //给自己发消息
                            self = new PrintWriter(this.socket.getOutputStream());
                            self.println("exit");
                            self.flush();
                        }*/
                    }
                    list.remove(this);
                    System.out.println(this.socket.getRemoteSocketAddress()+"已下线");
                }else{
                    //若自己不是退出
                    for (Tasker tasker : list) {
                        if (tasker != this) {
                            //获得其他人的通信管道
                            other = new PrintWriter(tasker.socket.getOutputStream());
                            other.println(this.socket.getRemoteSocketAddress()+"说："+str);
                            other.flush();
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

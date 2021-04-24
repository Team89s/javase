package com.igeek.javase.day19.tcp.tcp4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @version 1.0
 * @Description ReadThread  读线程
 * @Author chenmin
 * @Date 2020/12/9 11:21
 */
public class ReadThread extends Thread {
    private Socket socket;

    public ReadThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ){
            String line;
            while((line = br.readLine())!=null){
                if(line.equals("exit")){
                    System.out.println(socket.getRemoteSocketAddress()+"已下线");
                }else{
                    System.out.println(socket.getRemoteSocketAddress()+"说："+line);
                }
            }
        } catch (IOException e) {
            System.out.println("我下线了~~~");
        }
    }
}

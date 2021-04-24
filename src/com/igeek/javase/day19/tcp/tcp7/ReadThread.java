package com.igeek.javase.day19.tcp.tcp7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @version 1.0
 * @Description 读线程
 * @Author chenmin
 * @Date 2020/12/9 14:17
 */
public class ReadThread implements Runnable{
    private Socket socket;

    public ReadThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));){
            String str = null;
            while ((str = br.readLine())!=null){
                System.out.println(str);
            }
        } catch (IOException e) {
            System.out.println("拜拜嘞~~~");
        }
    }
}

package com.igeek.javase.day19.tcp.tcp4;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/9 11:21
 */
public class WriteThread extends Thread {
    private Socket socket;

    public WriteThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try(
                PrintWriter pw = new PrintWriter(socket.getOutputStream());
                Scanner sc = new Scanner(System.in);
        ){
            while (true){
                String s = sc.nextLine();
                pw.println(s);
                pw.flush();

                if(s.equals("exit")){
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
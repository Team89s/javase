package com.igeek.javase.day17.syn.ticket;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/1 10:02
 */
public class Ticket implements Runnable {

    private int ticketId = 100;

    @Override
    public void run() {
        while (true){
            if(ticketId==0){
                break;
            }
            sellTicket();
        }
    }

    public synchronized void sellTicket(){
        if(ticketId>0){
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"购票成功，购票号为"+ticketId);
            ticketId--;
        }
    }
}

package com.igeek.javase.day17.test;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/8 11:35
 *
 * 请按要求编写多线程应用程序，模拟多个人通过一个山洞：
 * 			1.这个山洞每次只能通过一个人，每个人通过山洞的时间为5秒；
 * 			2.随机生成10个人，同时准备过此山洞，显示每次通过山洞人的姓名；
 */
public class Test17_2_2 {

    public static void main(String[] args) {
        //MyRun myRun = new MyRun();
        for (int i = 1; i <=10 ; i++) {
            new Thread(new MyRun(),"person"+i).start();
        }
    }

}
class MyRun implements Runnable{
    @Override
    public void run() {
        synchronized (MyRun.class){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"正在通过山洞！");
        }
    }
}

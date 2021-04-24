package com.igeek.javase.day17.test;

import java.util.Random;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/8 14:03
 *
 * 编写线程同步模拟应用程序:
 * 	1. 大气环境数据为:温度,湿度,风速；
 * 	2. 一个大气环境传感器测量环境数据需要5秒时间；
 * 	3. 一个计算机读取传感器获得数据需要0.01秒时间；
 * 	4. 模拟100个计算机读取大气环境传感器获取的随机温度,湿度,风速；
 */
public class Test17_2_3 {

    public static void main(String[] args) {
        Sensor sensor = new Sensor();

        for (int i = 1; i <=100 ; i++) {
            new Thread(sensor).start();
        }

    }

}
class Sensor implements Runnable{
    byte[] lock = new byte[0];
    Random random = new Random();

    @Override
    public void run() {
        synchronized (lock){
            //一个大气环境传感器测量环境数据需要5秒时间；
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //大气环境数据为:温度,湿度,风速
            int temperature = random.nextInt(100)+1;
            int humidity = random.nextInt(50)+1;
            int windSpeed = random.nextInt(80)+1;

            //一个计算机读取传感器获得数据需要0.01秒时间；
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+",温度："+temperature+",湿度："+humidity+"，风速："+windSpeed);
            System.out.println("----------------------");
        }
    }
}

package com.igeek.javase.day04.interfaces.demo;

/**
 * @version 1.0
 * @Description 测试类
 * @Author chenmin
 * @Date 2020/11/2 11:20
 */
public class Test {

    public static void main(String[] args) {

        //测试U盘读写操作
        IStorage upan = new Upan();
        Computer computer = new Computer(upan);
        computer.readData();
        computer.writeData();

        //测试Mp3读写操作
        IStorage mp3 = new Mp3();
        computer = new Computer(mp3);
        computer.readData();
        computer.writeData();
        //播放音乐
        ((Mp3)mp3).playMusic();
    }

}

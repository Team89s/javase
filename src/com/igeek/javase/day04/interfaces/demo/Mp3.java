package com.igeek.javase.day04.interfaces.demo;

/**
 * @version 1.0
 * @Description Mp3类
 * @Author chenmin
 * @Date 2020/11/2 11:20
 */
public class Mp3 implements IStorage{

    //读
    @Override
    public void read(){
        System.out.println("Mp3 读数据....");
    }

    //写
    @Override
    public void write(){
        System.out.println("Mp3 写数据....");
    }

    //播放音乐
    public void playMusic(){
        System.out.println("Mp3 播放音乐中....");
    }

}

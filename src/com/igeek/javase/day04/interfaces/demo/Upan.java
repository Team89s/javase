package com.igeek.javase.day04.interfaces.demo;

/**
 * @version 1.0
 * @Description U盘类
 * @Author chenmin
 * @Date 2020/11/2 11:20
 */
public class Upan implements IStorage{

    //读
    @Override
    public void read(){
        System.out.println("Upan 读数据....");
    }

    //写
    @Override
    public void write(){
        System.out.println("Upan 写数据....");
    }


}

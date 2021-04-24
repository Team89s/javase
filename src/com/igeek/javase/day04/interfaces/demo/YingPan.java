package com.igeek.javase.day04.interfaces.demo;

/**
 * @version 1.0
 * @Description 硬盘类
 * @Author chenmin
 * @Date 2020/11/2 11:20
 */
public class YingPan implements IStorage{

    //读
    @Override
    public void read(){
        System.out.println("YingPan 读数据....");
    }

    //写
    @Override
    public void write(){
        System.out.println("YingPan 写数据....");
    }


}

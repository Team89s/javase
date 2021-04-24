package com.igeek.javase.day04.interfaces.demo;

/**
 * @version 1.0
 * @Description 计算机类
 * @Author chenmin
 * @Date 2020/11/2 11:19
 *
 * 面向接口编程：代码拓展性好，实现可插拔式编程（组件化开发），解耦
 *
 */
public class Computer {

    //一对一关联
    private IStorage storage;


    public Computer(IStorage storage){
        this.storage = storage;
    }

    //读数据
    public void readData(){
        System.out.println("电脑开始读数据....");
        storage.read();
    }


    //写数据
    public void writeData(){
        System.out.println("电脑开始写数据....");
        storage.write();
    }

}

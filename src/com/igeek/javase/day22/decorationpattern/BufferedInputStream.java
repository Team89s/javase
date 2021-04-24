package com.igeek.javase.day22.decorationpattern;

/**
 * @version 1.0
 * @Description 字节流  输入流   作用：高效，自带缓冲区
 * @Author chenmin
 * @Date 2020/12/17 11:37
 *
 * 装饰类：提升原始类的方法功能
 */
public class BufferedInputStream extends InputStream{

    private InputStream inputStream;

    public BufferedInputStream(InputStream inputStream){
        this.inputStream = inputStream;
    }

    @Override
    public void read() {
        System.out.println("开启高效处理方式....");
        inputStream.read();
    }

    @Override
    public void close() {
        System.out.println("开启高效处理方式....");
        inputStream.close();
    }
}

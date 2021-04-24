package com.igeek.javase.pattern.decoration;

/**
 * @version 1.0
 * @Description 字节流  输入流  作用：文件操作
 * @Author chenmin
 * @Date 2020/12/17 11:35
 *
 * 原始类
 */
public class FileInputStream extends InputStream {

    @Override
    public void read() {
        System.out.println("文件  读取数据");
    }

    @Override
    public void close() {
        System.out.println("关闭流资源");
    }
}

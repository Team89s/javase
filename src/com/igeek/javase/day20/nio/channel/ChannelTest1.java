package com.igeek.javase.day20.nio.channel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/11 10:46
 *
 * 需求1：本地文件写数据，使用前面学习后的ByteBuffer(缓冲) 和 FileChannel(通道)，
 * 将 "hello world" 写入到1.txt 中，若文件不存在就创建。
 */
public class ChannelTest1 {

    public static void main(String[] args) {
        //1.先创建字节缓冲区，将字符串添加至缓冲区中
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        String str = "hello world";
        buffer.put(str.getBytes());

        try (
                //2.创建文件输出流对象
                FileOutputStream fos = new FileOutputStream("1.txt");
        ){
            //3.通过输出流对象，获取文件通道对象
            FileChannel channel = fos.getChannel();

            //4.读写切换
            buffer.flip();

            //5.通过文件通道对象，对缓冲区做写操作
            channel.write(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

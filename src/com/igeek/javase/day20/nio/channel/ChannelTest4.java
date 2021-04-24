package com.igeek.javase.day20.nio.channel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/11 14:46
 *
 * 需求4：拷贝文件transferFrom 方法，使用 FileChannel(通道) 和 方法  transferFrom ，
 * 完成文件的拷贝，拷贝一张图片。
 */
public class ChannelTest4 {

    public static void main(String[] args) {

        //public long transferFrom(ReadableByteChannel src, long position, long count)
        //从目标通道中复制数据到当前通道

        try (
                //输入的文件通道
                FileChannel srcChannel = new FileInputStream("D:\\aaa\\Test.txt").getChannel();
                //输出的文件通道
                FileChannel destChannel = new FileOutputStream("D:\\ccc\\new.txt").getChannel();
         ){
            //拷贝
            destChannel.transferFrom(srcChannel,0,srcChannel.size());
            System.out.println("拷贝完成");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}




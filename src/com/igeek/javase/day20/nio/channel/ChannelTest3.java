package com.igeek.javase.day20.nio.channel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/11 14:23
 *
 * 需求3：使用一个Buffer完成文件读取，使用 FileChannel(通道) 和 方法 read , write，
 * 完成文件的拷贝，拷贝一个文本文件abc.txt  , 放在项目下即可。
 */
public class ChannelTest3 {

    public static void main(String[] args) {

        try (
                //输入的文件通道
                FileChannel inChannel = new FileInputStream("D:\\aaa\\Test.txt").getChannel();
                //输出的文件通道
                FileChannel outChannel = new FileOutputStream("new.txt").getChannel();
        ){
            //创建字节缓冲区，代表每次只能存储5个字节
            ByteBuffer buffer = ByteBuffer.allocate(5);

            while (true){
                //清除   position = 0;  limit = capacity;  mark = -1;
                buffer.clear();

                //将通道中的数据 读 至缓冲区
                int read = inChannel.read(buffer);
                if(read==-1){
                    break;
                }

                //切换读写   limit = position;  position = 0;  mark = -1;
                buffer.flip();

                //将缓冲区中的数据  写  至通道中
                outChannel.write(buffer);
            }
            System.out.println("拷贝完成");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

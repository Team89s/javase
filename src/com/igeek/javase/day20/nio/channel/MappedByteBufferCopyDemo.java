package com.igeek.javase.day20.nio.channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @version 1.0
 * @Description MappedByteBuffer 拷贝
 * @Author chenmin
 * @Date 2020/12/11 16:18
 */
public class MappedByteBufferCopyDemo {

    public static void main(String[] args) throws IOException {

        FileChannel inChannel = new FileInputStream("1.txt").getChannel();
        FileChannel outChannel = new FileOutputStream("2.txt").getChannel();

        //拷贝的工作
        MappedByteBuffer mappedByteBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        outChannel.write(mappedByteBuffer);

        System.out.println("完成拷贝");
    }

}

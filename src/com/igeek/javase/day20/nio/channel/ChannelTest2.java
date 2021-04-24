package com.igeek.javase.day20.nio.channel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/11 11:34
 *
 * 需求2：本地文件读数据，使用前面学习后的ByteBuffer(缓冲) 和 FileChannel(通道)，
 * 将 abc.txt 中的数据读入到程序，并显示在控制台屏幕，假定文件已经存在。
 */
public class ChannelTest2 {

    public static void main(String[] args) {

        File file = new File("1.txt");
        //System.out.println("文件的字节长度："+file.length());  //24
        //方式一：根据文件字节长度指定ByteBuffer可以存放的字节数
        ByteBuffer buffer = ByteBuffer.allocate((int)file.length());  //内置byte[]

        //方式二：直接指定ByteBuffer可以存放的字节数为1024
        //ByteBuffer buffer = ByteBuffer.allocate(1024);
        try (
                //1.创建文件输入流对象
                FileInputStream fis = new FileInputStream(file);
        ){
            //2.通过文件输入流对象，获取文件通道，进行文件的读操作
            FileChannel channel = fis.getChannel();
            //3.获取文件通道，进行文件的读操作
            int read = channel.read(buffer);
            //4.控制台输出打印
            //方式一：
            System.out.println(new String(buffer.array()));

            //方式二：若ByteBuffer.allocate(1024)，则
            //System.out.println(new String(buffer.array(),0,read));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

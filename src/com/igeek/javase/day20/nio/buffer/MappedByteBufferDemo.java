package com.igeek.javase.day20.nio.buffer;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @version 1.0
 * @Description MappedByteBuffer类
 * @Author chenmin
 * @Date 2020/12/11 15:18
 *
 * MappedByteBuffer作用：可以让文件直接在内存（堆外的内存）中进行修改，而操作系统不需要拷贝一次，
 * 有点像DirectByteBuffer，实际上DirectByteBuffer也是MappedByteBuffer作用的子类。
 *
 * MappedByteBuffer
 * 1.直接内存 ： 由操作系统直接分配
 * 2.put()添加元素  unsafe.putByte(ix(nextPutIndex()), ((x)));   unsafe是sun公司留的操作底层的后门
 * 3.DirectByteBuffer是MappedByteBuffer的子类
 *
 * ByteBuffer  byte[] hb
 * 1.一般创建的对象、数组等等，都是由JVM java虚拟机来分配内存空间存储
 * 2.put()添加元素  hb[ix(nextPutIndex())] = x;  直接操作内存中的的数组
 */
public class MappedByteBufferDemo {

    public static void main(String[] args) throws IOException {
        /*ByteBuffer buffer1 = ByteBuffer.allocate(10);   //在“JVM分配的内存”中直接创建了byte[] hb供操作
        System.out.println(buffer1.getClass());  //class java.nio.HeapByteBuffer
        buffer1.put((byte)10);

        ByteBuffer buffer2 = ByteBuffer.allocateDirect(10);   //由操作系统在“直接内存”中操作
        System.out.println(buffer2.getClass());  //class java.nio.DirectByteBuffer
        buffer2.put((byte)10);*/

        //支持对随机访问文件的读取和写入。  模式选择可读可写
        RandomAccessFile file = new RandomAccessFile("1.txt","rw");

        //通过文件对象获得操作的文件管道
        FileChannel channel = file.getChannel();

        /**
         * 通过文件管道，创建缓冲区对象
         * 第一个参数：指定操作模式 ，此处选择的是可读可写
         * 第二个参数：文件中的位置，映射区域从此位置开始；
         * 第三个参数：要映射的区域大小
         *
         * hello world
         * 张三
         * abc
         *
         * 直接内存中  position 2  size 11
         * llo world
         *
         * 修改完毕文件中
         * heHlL worldA张三
         * abc
         */
        MappedByteBuffer mapBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 2, 11);
        //修改指定位置上的值
        mapBuffer.put(0,(byte)'H');  //此处修改的下标，是在直接内存中的元素的操作下标
        mapBuffer.put(2,(byte)'L');
        mapBuffer.put(10,(byte)'A');
        System.out.println("修改完成");
    }

}

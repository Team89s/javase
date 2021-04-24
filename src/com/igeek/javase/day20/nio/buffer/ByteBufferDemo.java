package com.igeek.javase.day20.nio.buffer;

import java.nio.ByteBuffer;

/**
 * @version 1.0
 * @Description ByteBuffer 字节缓冲区
 * @Author chenmin
 * @Date 2020/12/11 9:41
 *
 *  // Invariants: mark <= position <= limit <= capacity
 *     private int mark = -1;     标记
 *     private int position = 0;  当前操作的下标
 *     private int limit;         操作下标的上限（取不到）
 *     private int capacity;      容量
 */
public class ByteBufferDemo {

    public static void main(String[] args) {

        //allocateDirect(int capacity) 创建直接缓冲区（由操作系统直接分配内存，堆外内存-JVM以外的内存）
        ByteBuffer buffer = ByteBuffer.allocate(5);
        ByteBuffer buffer1 = ByteBuffer.allocateDirect(5);
        System.out.println(buffer.getClass());

        //给缓冲区中写输出
        buffer.put((byte)10);  //position++
        buffer.put((byte)20);  //position++
        buffer.put((byte)30);  //position++
        buffer.put(1,(byte)222);  //此时position未发生变化

        buffer.putFloat(111L);

        //切换，读写方向
        buffer.flip();  //position=0 , limit = position = 3

        //从缓冲区中读数据  position < limit 返回true
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());  //position++
        }
    }

}

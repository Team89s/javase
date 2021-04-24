package com.igeek.javase.day20.nio.buffer;

import java.nio.ByteBuffer;

/**
 * @version 1.0
 * @Description 只读Buffer
 * @Author chenmin
 * @Date 2020/12/11 15:12
 *
 * 只读buffer，顾名思义只能用来读，很有用的，让别人不能修改，只能读。
 * 只读buffer底层是：HeapByteBufferR，而普通buffer底层是：HeapByteBuffer
 * 如果向里面put数据会抛出异常，看源码会发现，他的put方法就是直接抛异常。
 */
public class ReadOnlyBufferTest {

    public static void main(String[] args) {

        ByteBuffer buffer = ByteBuffer.allocate(5);

        for (int i = 0; i < buffer.capacity()-1; i++) {
            buffer.put((byte)(i*2));
        }

        buffer.flip();

        //只读Buffer缓冲区  当前ByteBuffer实际类型是HeapByteBufferR
        ByteBuffer byteBuffer = buffer.asReadOnlyBuffer();
        //java.nio.ReadOnlyBufferException
        byteBuffer.put((byte)10);
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }

    }

}

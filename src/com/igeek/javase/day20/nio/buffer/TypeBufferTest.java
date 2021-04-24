package com.igeek.javase.day20.nio.buffer;

import java.nio.ByteBuffer;

/**
 * @version 1.0
 * @Description Buffer的类型化
 * @Author chenmin
 * @Date 2020/12/11 15:07
 *
 * getInt()  putInt()
 * ByteBuffer 支持类型化的put 和 get,
 * put 放入的是什么数据类型，get就应该使用相应的数据类型来取出，
 * 否则可能有 BufferUnderflowException 异常。
 */
public class TypeBufferTest {

    public static void main(String[] args) {

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        buffer.putInt(10);
        buffer.putDouble(12.3);
        buffer.putChar('陈');

        buffer.flip();

        System.out.println(buffer.getInt());
        System.out.println(buffer.getDouble());
        System.out.println(buffer.getInt());  //java.nio.BufferUnderflowException
    }

}

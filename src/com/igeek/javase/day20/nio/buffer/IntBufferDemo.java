package com.igeek.javase.day20.nio.buffer;

import java.nio.IntBuffer;

/**
 * @version 1.0
 * @Description IntBuffer类  缓冲区
 * @Author chenmin
 * @Date 2020/12/10 16:33
 */
public class IntBufferDemo {

    public static void main(String[] args) {
        /**
         * 1.先创建IntBuffer缓冲区对象，此缓冲区存放的是int类型的元素
         * final int[] hb;
         * IntBuffer 抽象类  extends继承了Buffer类
         */
        IntBuffer buffer = IntBuffer.allocate(5);

        //2.给buffer缓冲区添加元素  buffer.capacity()获取当前缓冲区的容量
        for (int i = 1; i <=buffer.capacity() ; i++) {
            buffer.put(i*2);
        }

        //3.切换方向，由写变成读
        buffer.flip();

        //4.将buffer缓冲区中元素取出
        //根据position的值，获取对应的元素
        buffer.position(4);
        buffer.limit(2);  //当position的值>limit的值时，position = limit

        //hasRemaining()返回true的条件是：position < limit
        while(buffer.hasRemaining()){
            System.out.println(buffer.get());  //2 4 6 8 10
            /**
             * mark  标记
             * capacity  容量，声明时指定，不可变
             * position  当前位置，可变
             * limit     可以操作的上限，可变
             */
        }

    }

}

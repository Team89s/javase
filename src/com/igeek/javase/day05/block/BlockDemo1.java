package com.igeek.javase.day05.block;

/**
 * @version 1.0
 * @Description 实例代码块
 * @Author chenmin
 * @Date 2020/11/2 16:58
 *
 * 实例代码块
 * 1.语法  {}
 * 2.与创建对象有关，随着对象创建而加载
 * 3.代码中出现的多个实例代码块，则顺序执行
 * 4.使用频率不高
 */
public class BlockDemo1 {

    //统计对象创建个数
    private static int count = 0;

    {
        count++;
        System.out.println("实例块1");
    }
    /*{
        System.out.println("实例块2");
    }
    {
        System.out.println("实例块3");
    }*/

    public static void main(String[] args) {
        //随着对象创建而加载实例块
        BlockDemo1 b1 = new BlockDemo1();
        System.out.println(b1.count);  //1

        System.out.println("------------------");

        BlockDemo1 b2 = new BlockDemo1();
        System.out.println(b1.count); //2
    }
}

package com.igeek.javase.day05.block;

/**
 * @version 1.0
 * @Description 静态代码块
 * @Author chenmin
 * @Date 2020/11/2 16:58
 *
 * 静态代码块
 * 1.语法 static{  }
 * 2.与类有关，随着类加载而加载，有且只会加载一次
 * 3.代码中出现的多个静态代码块，则顺序执行
 * 4.使用频率相对高些：加载properties文件
 */
public class BlockDemo2 {

    private static int count;

    static {
        count++;
        System.out.println("静态块1");
    }
   /* static {
        System.out.println("静态块2");
    }
    static {
        System.out.println("静态块3");
    }*/

    public static void main(String[] args) {
        BlockDemo2 b1 = new BlockDemo2();
        System.out.println(BlockDemo2.count);  //1

        System.out.println("-------------");

        BlockDemo2 b2 = new BlockDemo2();
        System.out.println(BlockDemo2.count);  //1
    }
}

package com.igeek.javase.day03.finals;

/**
 * @version 1.0
 * @Description final关键字
 * @Author chenmin
 * @Date 2020/10/30 15:16
 *
 * final 关键字：用于修饰不可改变内容。不可改变，最终的含义。可以用于修饰类、方法和变量。
 *
 * final 修饰变量，代表变量的值不可更改
 *    - 实例成员变量（属性）
 *          1.一旦使用final修饰后，需要先进行初始化赋值
 *          2.若不赋初始值，则必须在所有的构造方法中赋值
 *          3.若不赋初始值，实例代码块 ？？？是否必须赋值   是必须赋初始值
 *
 *    - 静态成员变量（static） 在内存中地址唯一，值唯一不可更改
 *          1.final修饰之后，静态的常量，需要先进行初始化赋值
 *          2.public static final 变量名全部大写，多个单词之间用_拼接
 *          3.若不赋初始值，静态代码块 ？？？是否必须赋值  是必须赋初始值
 *
 *    - 局部变量（方法中声明的变量）
 *          1.一旦被final修饰，值不可以更改
 *          2.方法中形参被final修饰，此方法不可以再更改形参的值
 *          （一般是让值被固定或者保护起来，执行的过程中防止被修改）
 *
 *  提问：
 *      final与 abstract 能否一起使用？？？  不可以一起使用
 */
public class FinalDemo2 {

    private final int age;

    //静态的常量
    public static final int SCORE_LEVEL;

    /*public FinalDemo2(){
        age = 10;
    }

    public FinalDemo2(int age){
        this.age = age;
    }*/

    {
        age = 10;
    }

    static {
        SCORE_LEVEL = 1;
    }

    //一旦final修饰了形参，形参的值不可以再更改
    public void work(/*final*/ int a){
        System.out.println(a++);
    }

    public void work(/*final*/ FinalDemo2 f){
        f = new FinalDemo2();
        System.out.println(f);
    }

    public static void main(String[] args) {
        //final的局部常量
        /*final */int a = 100;

        //执行work方法
        /*final */FinalDemo2 f = new FinalDemo2();
        f.work(a);
        f.work(f);
    }
}

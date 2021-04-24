package com.igeek.javase.day14.lambda;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/20 9:54
 *
 * 函数式接口
 * 1.接口
 * 2.有且只有一个抽象方法
 *
 * @FunctionalInterface 函数式接口的注解
 * 1.若接口加上此注解，则当前注解必须满足上述两个条件，否则直接报错
 * 2.若接口已满足上述两个条件，也可以不加上@FunctionalInterface注解
 * 3.效果，类似于@Override
 *
 */
@FunctionalInterface
public interface MyInterface {
    void work();

    //void sleep();

    default int eat(){
        return 0;
    }
}
class Test{

    public void init(MyInterface my){
        my.work();
    }

}

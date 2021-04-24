package com.igeek.javase.day08;

/**
 * @version 1.0
 * @Description 消极处理方式 - throw/throws
 * @Author chenmin
 * @Date 2020/11/6 14:07
 *
 * throw
 * 1.用于方法体中
 * 2.throw new 异常类型(String);  等价于  throw 异常对象;
 * 3.一旦方法中向上抛出，必须要结合throws一起使用
 * 4.使用场景：自定义异常（Exception、RuntimeException）
 * 5.特殊：
 *      若方法中throw抛出的是Exception，则调用此方法时，需要继续处理
 *      若方法中throw抛出的是RuntimeException，则调用此方法时，不需要继续处理，但是运行后满足条件会报错
 *
 * throws
 * 1.用于方法上
 * 2.throws 异常类型1,异常类型2,....
 * 3.一旦方法向上抛出异常后，若是main方法则直接抛给了JVM，若是其他方法，则抛给调用者
 */
public class ThrowExceptionDemo {

    public static void work(boolean flag) throws Exception { //3.抛给调用者
        if(flag){
            throw new Exception("出错啦！"); //2.抛给当前方法
        }
    }

    public static void method(boolean flag) throws RuntimeException {
        if(flag){
            throw new RuntimeException("出错啦！");
        }
    }

    public static void main(String[] args) throws Exception {  //4.main继续向上抛，抛给JVM
        ThrowExceptionDemo.work(true);  //1.引发源头

        //5.输出错误堆栈信息（显示异常的类型、原因、出错代码行），程序到此关闭

        //运行时报错 java.lang.RuntimeException: 出错啦！
        ThrowExceptionDemo.method(true);
    }

}

package com.igeek.javase.day08;

/**
 * @version 1.0
 * @Description 自定义异常
 * @Author chenmin
 * @Date 2020/11/6 15:51
 *
 * 自定义异常：在开发中根据自己业务的异常情况来定义异常类.(更多情况下，是作为业务逻辑异常存在的)
 * 1.extends Exception
 *      自定义一个编译期异常: 自定义类 并继承于`java.lang.Exception`。 调用时会必须解决异常
 *      自定义一个运行时期的异常类:自定义类 并继承于`java.lang.RuntimeException`。 调用时会无须解决异常
 * 2.重写构造方法
 */
public class LoginException extends Exception{

    public LoginException() {
        super();
    }

    public LoginException(String message) {
        super(message);
    }
}

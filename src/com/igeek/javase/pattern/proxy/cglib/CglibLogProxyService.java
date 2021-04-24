package com.igeek.javase.pattern.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @version 1.0
 * @Description cglib动态代理
 * @Author chenmin
 * @Date 2020/12/17 10:10
 *
 * cglib动态代理
 * 要求：
 * 1.在内存中动态构建子类，注意代理的类需要提供一个公开的无参的构造方法，否则将无法创建代理对象
 * 2.在内存中动态构建子类，注意代理的类不能为final，否则报错
 * 3.目标对象的方法如果为final/static,那么就不会被拦截,即不会执行目标对象额外的业务方法.
 *
 * 优势：静态代理和JDK代理模式都要求目标对象是实现一个接口,但是有时候目标对象只 是一个单独的对象,
 * 并没有实现任何的接口,这个时候可使用目标对象子类来实现 代理-这就是Cglib代理。
 *
 * 劣势：Proxy代理类需要实现接口 implements MethodInterceptor
 *
 * 使用场景：
 * 在AOP编程中如何选择代理模式：
 * 若目标对象需要实现接口，用JDK代理；
 * 若目标对象不需要实现接口，用Cglib代理。
 */
public class CglibLogProxyService implements MethodInterceptor {

    //目标对象
    private BankService target;

    public CglibLogProxyService(BankService target){
        this.target = target;
    }

    //获得代理对象的方法
    public BankService getProxy(){
        //代理对象
        BankService proxy = null;
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(target.getClass());
        //设置回调函数
        enhancer.setCallback(this);
        /**
         * create() 创建代理对象
         * 1.要求Superclass中的必须提供一个无参的公开的构造方法
         * 2.创建对象完毕，则回调执行回调函数Callback，代理对象具体去做的方法逻辑，即intercept()中的逻辑
         */
        proxy = (BankService)enhancer.create();
        return proxy;
    }

    /**
     * intercept  拦截原理
     * @param proxy   代理对象，此处不用
     * @param method  target类中方法的对象
     * @param args    target类中方法形参
     * @param methodProxy  方法的代理，此处不用
     * @return  target类中的方法的执行结果，若无返回值则为null
     * @throws Throwable
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        String methodName = method.getName();
        System.out.println("the method "+methodName+" begin "+ Arrays.toString(args));
        long beginTime = System.currentTimeMillis();
        //核心业务执行开始
        //执行目标对象中的方法
        Object result = method.invoke(target, args);
        //核心业务执行结束
        long endTime = System.currentTimeMillis();
        System.out.println(methodName+"()耗时："+(endTime-beginTime)/1000.0+"s");
        return result;
    }
}

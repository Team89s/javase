package com.igeek.javase.pattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @version 1.0
 * @Description JDK动态代理模式 - 新增日志需求
 * @Author chenmin
 * @Date 2020/12/17 9:27
 *
 * 面向切面编程  - Spring AOP重要核心思想
 *
 * Spring AOP
 * 1.默认使用JDK动态代理（一定要有接口）
 * 2.若没有接口，此时会自动转变成Cglib代理
 * 在AOP编程中如何选择代理模式：若目标对象需要实现接口，用JDK代理；
 * 若目标对象不需要实现接口，用Cglib代理。
 *
 * JDK动态代理模式
 * 优点：
 * 1.动态代理可以在不改变方法源码的情况下，实现对方法功能的增强
 * 2.动态代理类不仅简化了编程工作，而且提高了软件系统的可扩展性
 * 缺点：
 * 只能针对接口的实现类做代理对象，普通类是不能做代理对象的。
 */
public class BankLogProxyService<T> {

    //target目标对象
    private T target;

    public BankLogProxyService(T target){
        this.target = target;
    }

    //提供一个获得代理对象的方法
    public T getProxy(){
        //proxy 代理对象
        T proxy = null;

        //1.类加载器
        ClassLoader loader = target.getClass().getClassLoader();

        //2.target实现的所有的接口
        Class<?>[] interfaces = target.getClass().getInterfaces();

        //3.处理器，通过反射执行目标对象target中的方法，将代理类中的逻辑作用在target的方法中
        InvocationHandler handler = new InvocationHandler() {
            /**
             * invoke方法
             * @param proxy   代理对象，一般不去使用
             * @param method  target中的的方法的对象
             * @param args    target中的的方法的形参
             * @return  当前方法的执行结果，若没有返回值则是null
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                System.out.println("the method "+methodName+" begin "+ Arrays.toString(args));
                long beginTime = System.currentTimeMillis();
                //执行目标对象中的方法
                Object result = method.invoke(target, args);
                long endTime = System.currentTimeMillis();
                System.out.println(methodName+"()耗时："+(endTime-beginTime)/1000.0+"s");
                return result;
            }
        };

        //给proxy对象进行实例化
        proxy = (T) Proxy.newProxyInstance(loader,interfaces,handler);
        return proxy;
    }
}

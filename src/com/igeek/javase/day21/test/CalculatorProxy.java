package com.igeek.javase.day21.test;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/22 20:00
 *
 * 设置一个类Calculator，包含4个方法：加、减、乘、除，在4个方法上
 * 添加日志处理：在程序执行期间追踪正在发生的活动。
 * 要求使用动态代理实现日志追踪的效果。
 */
public class CalculatorProxy {

    public ICalculator target;

    public  CalculatorProxy(ICalculator target){
        this.target = target;
    }

    public ICalculator getProxy(){
        return (ICalculator)Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (Object proxy, Method method, Object[] args) -> {
                    String methodName = method.getName();
                    System.out.println("日志追踪：the method "+methodName+" begin with "+ Arrays.asList(args));
                    Object result = method.invoke(target, args);
                    System.out.println("日志追踪：the method "+methodName+" end with "+result);
                    return result;
                }
        );
    }
}

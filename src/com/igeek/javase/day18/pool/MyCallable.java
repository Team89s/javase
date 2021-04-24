package com.igeek.javase.day18.pool;

import java.util.concurrent.Callable;

/**
 * @version 1.0
 * @Description Callable 获得线程执行的结果(正常结果/异常)
 * @Author chenmin
 * @Date 2020/12/1 16:22
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        return Thread.currentThread().getName()+"正在执行";
    }
}

package com.igeek.javase.day08;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version 1.0
 * @Description try...catch  积极处理方式
 * @Author chenmin
 * @Date 2020/11/6 14:22
 *
 * 面试题：final和finally和finalize三者之间的区别？
 * 1.final   修饰符，表示最终的
 * 2.finally 处理异常的关键字，无论正常执行或者发生异常，都必将执行finally，一般用于资源释放和日志写入
 * 3.finalize 当执行时，告知JVM当前引用不再需要，可以垃圾回收机制来进行回收
 *
 * try...catch
 * 1.语法
 * try{
 *     //可能出现异常的代码块
 * }catch(异常类型1 异常对象名){
 *     //一旦发生异常，并且发生的异常类型与之匹配，直接执行此catch的逻辑
 * }catch(异常类型2 异常对象名){
 *     //一旦发生异常，并且发生的异常类型与之匹配，直接执行此catch的逻辑
 * }finally{
 *     //无论正常执行或者发生异常，都必将执行finally（即使上面已经return，依旧坚挺执行）
 *     //资源释放或日志写入
 * }
 * .... //正常执行
 *
 *  注意： 1.异常类型1  < 异常类型2  2.try必写  catch和finally是可以省略其一的
 *
 *  JDK1.7简化写法
 *  try{
 *
 *  }catch(异常类型1 | 异常类型2 异常对象名){
 *
 *  }finally{
 *
 *  }
 *
 *  2.比较积极处理异常的方式
 *
 */
public class CatchDemo1 {

    public static void work()  {
        System.out.println("正在执行work()....");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date date = sdf.parse("2020-10/12");
            System.out.println(date);
        }catch (ParseException | NullPointerException e){
            //System.out.println("您当前日期格式输入有误！");
            //错误堆栈信息
            e.printStackTrace();
        }
        System.out.println("结束执行work()....");
    }

    public static void main(String[] args)  {
        CatchDemo1.work();
    }

}

package com.igeek.javase.day08;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version 1.0
 * @Description 异常
 * @Author chenmin
 * @Date 2020/11/6 10:48
 *
 * 异常：程序执行过程中，可能出现的不正常的事件流
 *
 * 编译期异常：
 *      1.概念：编写代码的过程中，出现的异常
 *      2.特点：若不解决，就会编译报错
 *      3.目的：启发警醒效果
 *      4.常见异常：
 *          ClassNotFoundException 类找不到异常
 *          ParseException  时间格式解析异常
 *          IOException  进行IO操作时可能引发的异常
 *      5.总结：除了运行期异常，都是编译期异常
 *
 *
 * 运行期异常：
 *      1.概念：在代码实际运行过程中，JVM抛出的异常
 *      2.特点：编译期间不显现，在运行中若出现异常则直接抛给JVM虚拟机
 *      3.目的：调bug了
 *      4.常见异常：
 *          ArrayIndexOutOfBoundsException  数组下标越界
 *          NullPointerException  空指针异常
 *          ClassCastException    类型转换异常
 *          NumberFormatException 数字格式化异常
 *          ArithmeticException   数学异常
 *      5.总结：
 *          RuntimeException 是运行期异常的父类
 *          运行期异常一旦出现，就要解决bug
 *          需要有很好的预见性
 *
 *
 */
public class ExceptionDemo1 {

    public static void main(String[] args) throws ParseException {
        System.out.println("-------编译期异常---------");
        /*throws ClassNotFoundException
        Class.forName("");*/

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2020-09-09");
        System.out.println(date);

        System.out.println("-------运行期异常---------");
        //System.out.println(args[0]);  //ArrayIndexOutOfBoundsException

        /*String str = null;
        System.out.println(str);
        System.out.println(str.length());*/  //NullPointerException

        /*Animal animal = new Tiger();
        Dog dog = (Dog)animal;  //ClassCastException
        dog.kanjia();*/

        //System.out.println(Integer.parseInt("10ab"));  //NumberFormatException

        int a = 10;
        int b = 0;
        System.out.println(a/b);  //ArithmeticException: / by zero
    }

}

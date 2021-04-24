package com.igeek.javase.day08.test;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/9 15:07
 */
public class Test1_07_throws {

    public static char myCharAt(String key , int index) throws Exception { //3.
        if(key==null){
            throw new Exception("操作字符串为null");
        }
        if(key.equals("")){
            throw new Exception("操作字符串为空串");
        }
        if(index<0 || index>=key.length()){
            throw new Exception("操作字符串下标越界"); //2.
        }
        return key.charAt(index);
    }

    //抛出异常  抛给JVM  效果：一旦出现异常，则停止并输出异常信息
    public static void main(String[] args) throws Exception {  //4
        System.out.println("main开始");
        //Test1_07_throws.myCharAt(null,-1); //1  程序到此结束
        Test1_07_throws.myCharAt("",-1); //1  程序到此结束
        //Test1_07_throws.myCharAt("abcABC123",-1); //1  程序到此结束
        System.out.println("main结束");
    }

}

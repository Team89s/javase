package com.igeek.javase.day08.test;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/9 15:07
 */
public class Test1_07_try {

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

    //try..catch  就地解决，不会影响程序的整个运行
    public static void main(String[] args)  {  //4
        System.out.println("main开始");
        try {
            //Test1_07_throws.myCharAt(null,-1); //1  程序到此结束
            Test1_07_try.myCharAt("",-1); //1  程序到此结束
            //Test1_07_throws.myCharAt("abcABC123",-1); //1  程序到此结束
        } catch (Exception e) {
            //打印输出错误信息
            e.printStackTrace();
        }
        System.out.println("main结束");
    }

}

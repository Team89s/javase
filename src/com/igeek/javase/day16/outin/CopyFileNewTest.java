package com.igeek.javase.day16.outin;

import java.io.*;

/**
 * @version 1.0
 * @Description 文件拷贝 - 简化关闭资源的操作
 * @Author chenmin
 * @Date 2020/11/24 16:49
 *
 * 关闭资源的操作
 *      try...catch...finally
 *
 * JDK1.7之后提供了新的关闭资源的方案
 *      try-with-resource
 *      注意：
 *      1.语法
 *          try(
 *              创建资源类的对象1;创建资源类的对象2
 *          ){
 *              //可能出现的异常代码块
 *          }catch(Exception e){
 *              //出现异常后，执行的操作
 *          }
 *      2.try()中只能放置资源类，资源类指的是implements Closeable的实现类
 *      3.当前创建的对象，不可以再更改值
 *      4.创建使用后，直接关闭资源；即使中间出现异常，直接关闭资源；
 */
public class CopyFileNewTest {

    public static void main(String[] args) {

        File source = new File("D:\\aaa\\文本.txt");
        File target = new File("E:\\test.txt");

        try(
                //读入：将文件读入到内存中
                FileInputStream fis = new FileInputStream(source);
                //写出：将文件写出到指定磁盘上
                FileOutputStream fos = new FileOutputStream(target);
        ){
            //边读边写
            byte[] bytes = new byte[1024];
            int len = 0;
            while((len=fis.read(bytes))!=-1){
                fos.write(bytes,0,len);
            }
            System.out.println("拷贝成功！");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

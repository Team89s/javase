package com.igeek.javase.day16.serializable;

import java.io.*;

/**
 * @version 1.0
 * @Description 反序列化
 * @Author chenmin
 * @Date 2020/11/26 10:41
 *
 * 反序列化：与序列化相反的过程，从文本中读入对象信息至内存
 * ObjectInputStream
 *      Object readObject() 从对象输入流对象。
 */
public class SerializableDemo2 {

    /**
     * 反序列化
     * @param destFile  目标文件
     */
    public static void unseria(File destFile){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(destFile))){
            //java.lang.IllegalArgumentException: 您当前数据被篡改，数据不合法！
            User user = (User)ois.readObject();
            System.out.println(user);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        unseria(new File("D:\\aaa\\user.txt"));
    }
}

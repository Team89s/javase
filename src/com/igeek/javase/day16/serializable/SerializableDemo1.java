package com.igeek.javase.day16.serializable;

import java.io.*;

/**
 * @version 1.0
 * @Description 序列化
 * @Author chenmin
 * @Date 2020/11/26 10:41
 *
 * 序列化：将内存中的对象信息，写出到文本中，持久化保存在磁盘上
 * ObjectOutputStream
 *          void writeObject(Object obj)  写入指定的对象。
 *
 *  注意：自定义的类若要进行序列化，必须实现Serializable接口
 */
public class SerializableDemo1 {

    /**
     * 序列化的过程
     * @param destFile  目标文件
     */
    public static void seria(File destFile){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(destFile))){
            User user = new User("张三",18,"123","江苏无锡");

            //java.io.NotSerializableException: com.igeek.javase.day13.io.serializable.User  当前User未实现序列化
            oos.writeObject(user);
            oos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        seria(new File("D:\\aaa\\user.txt"));
    }
}

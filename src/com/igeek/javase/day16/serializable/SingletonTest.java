package com.igeek.javase.day16.serializable;

import java.io.*;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/26 14:09
 */
public class SingletonTest {

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();

        //ByteArrayOutputStream和ByteArrayInputStream  字节数组的字节流，将对象包装成流进行操作，在内存中操作
        //序列化
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos)){
            oos.writeObject(Singleton.getInstance());
            oos.flush();

            //反序列化
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            Singleton s2 = (Singleton)ois.readObject();
            System.out.println(s1 == s2); //false 说明直接通过单例获取的对象与反序列化重构获得的对象不是同一个对象
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

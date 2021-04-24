package com.igeek.javase.day16.serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/26 10:41
 */
public class User implements Serializable {
    //序列版本号
    private static final long serialVersionUID = -39090853874707230L;

    private String name;
    private int age;
    //transient  当前属性不再会被序列化到文件中，获取时默认值null
    private transient String password;
    /**
     *  static 当前属性不再会被序列化到文件中，获取时默认值null
     *  属性一旦被static修饰，说明当前不再属于某个对象，属于类的；而持久化操作（序列化）本质上在文件中存储对象信息
     */
    private static String address;

    //新添加属性，可能会造成InvalidClassException（修改了类中的属性，造成与文本中不一致，解决方案：添加了serialVersionUID）
    private int num;

    /**
     * 提示信息发生篡改
     */
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        //仍然读取原本的文件信息
        ois.defaultReadObject();
        if(age<0 || age>100){
            throw new IllegalArgumentException("您当前数据被篡改，数据不合法！");
        }
    }

    public User() {
    }

    public User(String name, int age, String password, String address) {
        this.name = name;
        this.age = age;
        this.password = password;
        this.address = address;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return "User{name = " + name + ", age = " + age + ", password = " + password + ", address = " + address + "}";
    }
}

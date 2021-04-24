package com.igeek.javase.day16.serializable.clone;

import java.io.*;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/26 15:05
 */
public class Student /*implements Cloneable*/ implements Serializable{

    private static final long serialVersionUID = 8316175142119905010L;
    private String name;
    private int age;
    //一对一关联
    private Major major;

    /*@Override
    protected Student clone() throws CloneNotSupportedException {
        //深克隆
        Student stu = (Student)super.clone();
        stu.setMajor(major.clone());
        return stu;

        //浅克隆
        //return (Student)super.clone();
    }*/

    //通过序列化和反序列化完成深克隆
    public Student clone(){
        //序列化
        try(
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos);
        ){
            oos.writeObject(this);
            oos.flush();

            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
            Student stu = (Student) ois.readObject();
            return stu;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Student() {
    }

    public Student(String name, int age, Major major) {
        this.name = name;
        this.age = age;
        this.major = major;
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
     * @return major
     */
    public Major getMajor() {
        return major;
    }

    /**
     * 设置
     * @param major
     */
    public void setMajor(Major major) {
        this.major = major;
    }

    public String toString() {
        return "Student{name = " + name + ", age = " + age + ", major = " + major + "}";
    }
}

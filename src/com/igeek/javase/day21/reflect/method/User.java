package com.igeek.javase.day21.reflect.method;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/15 16:25
 */
public class User extends Person{

    private String name;
    private String pwd;
    private int age;

    //方法
    public void eat(){

    }

    public boolean work(String str){
        return false;
    }

    private int sleep(int a){
        System.out.println("sleep(a) = "+a);
        return a;
    }

    private static int count(){
        return 0;
    }

    public User() {
    }

    public User(String name, String pwd, int age) {
        this.name = name;
        this.pwd = pwd;
        this.age = age;
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
     * @return pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * 设置
     * @param pwd
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
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

    public String toString() {
        return "User{name = " + name + ", pwd = " + pwd + ", age = " + age + "}";
    }
}

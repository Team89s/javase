package com.igeek.javase.day01.visible.test;

/**
 * @version 1.0
 * @Description 封装
 * @Author chenmin
 * @Date 2020/10/27 16:36
 *
 * 封装：
 * 1.隐藏其内部结构
 * 2.私有化的属性，公开的getter和setter方法
 * 3.this 代表当前正在创建的对象，当前正在使用的对象
 */
public class Person {

    private String name;
    private String sex;

    /**
     * 构造方法
     * 1.方法名与类名一致
     * 2.没有返回值，更没有void
     * 3.实例化对象
     * 4.若类中未提供构造方法，将默认提供一个无参的构造方法；
     * 当类中提供了有参的构造方法之后，将不再提供默认无参构造方法
     * 5.构造方法也可以进行方法重载
     */
    public Person(){

    }

    public Person(String name,String sex){
        //this 代表当前正在创建的对象
        this.name = name;
        if(sex.equals("男") || sex.equals("女")){
            this.sex = sex;
        }
    }

    //name  getter获取，返回名称
    public String getName(){
        return this.name;
    }
    //name  setter设置，传参
    public void setName(String name){
        /**
         *  this 当前正在使用的对象
         *  this区分局部变量和成员变量
         */

        this.name = name;
    }
    //sex  getter获取，返回性别
    public String getSex(){
        return this.sex;
    }
    //sex  setter设置，传参
    public void setSex(String sex){
        if(sex.equals("男") || sex.equals("女")){
            this.sex = sex;
        }
    }

    void eat(){
        System.out.println(this.name+"正在吃饭...");
    }

    void sleep(){
        System.out.println(this.sex+"同学去睡觉...");
    }

}

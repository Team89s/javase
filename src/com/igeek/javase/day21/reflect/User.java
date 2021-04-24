package com.igeek.javase.day21.reflect;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/15 15:20
 */
public class User extends Person{

    //属性
    private String name;
    private int age;

    //构造方法
    public User(){

    }

    public User(String name){
        this.name = name;
    }

    //方法
    public void eat(){

    }

    public User login(String name){
        return new User(name);
    }

    //内部类
    public class InnerClass{
        private String name;

        public void work(){
            System.out.println("正在工作");
        }
    }

}

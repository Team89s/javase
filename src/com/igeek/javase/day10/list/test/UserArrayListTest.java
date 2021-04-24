package com.igeek.javase.day10.list.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/11 14:35
 *
 * List作业
 * 模拟登陆，编写用户类，测试类。
 *   1>.给集合中存储5个用户对象。
 *   2>.从控制台输入用户名和密码，和集合中的对象信息进行比较，
 *   相同表示成功，不同表示失败。
 *   3>.有三次输入机会。
 *
 *  ArrayList 集合
 *  特点：允许重复，保留原存储顺序，可以插入null值
 *
 */
public class UserArrayListTest {

    public static void main(String[] args) {
        User user1 = new User("张三","123");
        User user2 = new User("里斯","123");
        User user3 = new User("王二","123");
        User user4 = new User("张三","123");
        User user5 = new User("赵武","123");

        //给集合中存储5个用户对象
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(null);
        System.out.println(list);

        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        A:for(int i=0;i<3;i++){
            System.out.println("请输入姓名：");
            String username = sc.nextLine();
            System.out.println("请输入密码：");
            String password = sc.nextLine();

            B:for (User user : list) {
                if(user!=null){
                    if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
                        flag = true;
                        System.out.println("登录成功");
                        break A;
                    }
                }
            }
        }
        if(!flag){
            System.out.println("登录失败");
        }

    }

}

package com.igeek.javase.day13.jpanel;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Description UserDao  CRUD
 * @Author chenmin
 * @Date 2020/11/18 10:08
 */
public class UserDao {

    private static List<User> list = new ArrayList<>();

    //插入用户信息
    public void insert(User user){
        list.add(user);
    }

    //查询用户信息
    public User selectOne(String name, String pwd){
        for (User user : list) {
            if(user!=null && name.equals(user.getName()) && pwd.equals(user.getPwd())){
                return user;
            }
        }
        return null;
    }

}

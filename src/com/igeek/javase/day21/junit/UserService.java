package com.igeek.javase.day21.junit;

/**
 * @version 1.0
 * @Description 用户类的业务逻辑
 * @Author chenmin
 * @Date 2020/12/15 14:21
 */
public class UserService {

    //登录
    public boolean login(String username,String password){
        if("zhangsan".equals(username) && "123".equals(password)){
            return true;
        }
        return false;
    }

    //查询
    public void selectOne(String name){
        if("lisi".equals(name)){
            System.out.println("查询成功");
        }else{
            System.out.println("查询失败");
        }
    }

}

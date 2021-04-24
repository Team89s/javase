package com.igeek.javase.day08;

import javax.swing.*;

/**
 * @version 1.0
 * @Description 登录测试，测试自定义的登录异常
 * @Author chenmin
 * @Date 2020/11/6 15:54
 */
public class LoginTest {

    public static boolean login(String username,String password) throws LoginException {
        if("张三".equals(username) && "123".equals(password)){
            return true;
        }else{
            //执行到异常，已经结束
            throw new LoginException("出现登录异常，请检测您的账号与密码！");
        }
    }

    public static void main(String[] args) {
        try {
            boolean flag = LoginTest.login("张三","123");
            if(flag){
                //WARNING_MESSAGE
                JOptionPane.showMessageDialog(null,"登录成功","登录通知",JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (LoginException e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"登录通知",JOptionPane.ERROR_MESSAGE);
        }
    }
}

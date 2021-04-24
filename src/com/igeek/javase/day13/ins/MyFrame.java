package com.igeek.javase.day13.ins;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @version 1.0
 * @Description JDialog对话框
 * @Author chenmin
 * @Date 2020/11/18 16:29
 */
public class MyFrame extends JFrame {

    public MyFrame(){
        super("JDialog对话框案例");
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("点我点我");
        this.getContentPane().add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //弹出自定义的对话框
                //new MyDialog(MyFrame.this,"这是一个对话框").setVisible(true);

                //输入框
                String str = JOptionPane.showInputDialog(null, "请输入您的账号");
                System.out.println(str);

                //确认框  0是  1否  2取消
                int i = JOptionPane.showConfirmDialog(null, "您确定要退出么？");
                System.out.println("i = "+i);
                if(i==0){
                    //退出
                    System.exit(0);
                }

                //提示框
                JOptionPane.showMessageDialog(null,"登录失败！");

            }
        });
    }

    public static void main(String[] args) {
        new MyFrame().setVisible(true);
    }
}
//自定义的对话框
class MyDialog extends JDialog{
    /**
     * MyDialog的构造方法
     * @param owner  容器
     * @param title  标题
     */
    public MyDialog(Frame owner, String title) {
        this.setTitle(title);
        this.setSize(200,200);
        this.setLocationRelativeTo(null);
        this.add(new JTextField("文本框Hello World"));
    }
}

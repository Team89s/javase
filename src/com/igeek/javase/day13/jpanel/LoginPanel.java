/*
 * Created by JFormDesigner on Wed Nov 18 15:04:59 CST 2020
 */

package com.igeek.javase.day13.jpanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author 11
 */
public class LoginPanel extends JPanel {

    private MyFrame my;

    public LoginPanel(MyFrame my) {
        this.my = my;
        initComponents();
    }

    //登录按钮
    private void loginButtonActionPerformed(ActionEvent e) {
        String name = textField.getText();
        String pwd = new String(passwordField.getPassword());
        if(name!=null && !name.equals("") && pwd!=null && !pwd.equals("")){
            User user = my.dao.selectOne(name, pwd);
            if(user!=null){
                //登录成功，跳转至main界面
                my.skip("main");
                //清空登录页面
                clearLogin();
                //初始化main界面数据
                my.mainPanel.initMain(user);
            }else{
                JOptionPane.showMessageDialog(null,"登录失败，登录时用户名和密码不匹配！");
            }
        }else{
            JOptionPane.showMessageDialog(null,"登录失败，登录时用户名或密码不能为空！");
        }
    }

    //清空页面
    private void clearLogin() {
        textField.setText("");
        passwordField.setText("");
    }

    //注册按钮
    private void registButtonActionPerformed(ActionEvent e) {
        my.skip("regist");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label = new JLabel();
        nameLabel = new JLabel();
        pwdLabel = new JLabel();
        textField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton();
        registButton = new JButton();

        //======== this ========
        setLayout(null);

        //---- label ----
        label.setText("\u767b\u5f55\u754c\u9762");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));
        add(label);
        label.setBounds(110, 45, 160, 35);

        //---- nameLabel ----
        nameLabel.setText("\u59d3  \u540d");
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        add(nameLabel);
        nameLabel.setBounds(55, 105, 80, nameLabel.getPreferredSize().height);

        //---- pwdLabel ----
        pwdLabel.setText("\u5bc6  \u7801");
        pwdLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pwdLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        add(pwdLabel);
        pwdLabel.setBounds(55, 155, 80, 22);
        add(textField);
        textField.setBounds(150, 105, 155, textField.getPreferredSize().height);
        add(passwordField);
        passwordField.setBounds(150, 155, 155, passwordField.getPreferredSize().height);

        //---- loginButton ----
        loginButton.setText("\u767b\u5f55");
        loginButton.addActionListener(e -> loginButtonActionPerformed(e));
        add(loginButton);
        loginButton.setBounds(new Rectangle(new Point(95, 220), loginButton.getPreferredSize()));

        //---- registButton ----
        registButton.setText("\u6ce8\u518c");
        registButton.addActionListener(e -> registButtonActionPerformed(e));
        add(registButton);
        registButton.setBounds(230, 220, 74, 24);

        setPreferredSize(new Dimension(400, 300));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label;
    private JLabel nameLabel;
    private JLabel pwdLabel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    //回显姓名
    public void initLogin(User user){
        textField.setText(user.getName());
    }
}

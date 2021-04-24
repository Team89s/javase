/*
 * Created by JFormDesigner on Wed Nov 18 10:20:44 CST 2020
 */

package com.igeek.javase.day13.jframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author 11
 */
public class LoginFrame extends JFrame {

    private UserDao dao;

    public LoginFrame() {
        dao = new UserDao();
        initComponents();
    }

    //登录按钮触发的操作
    private void loginButtonActionPerformed(ActionEvent e) {
        String name = textField.getText();
        String pwd = new String(passwordField.getPassword());
        if(name!=null && !name.equals("") && pwd!=null && !pwd.equals("")){
            //登录
            User user = dao.selectOne(name, pwd);
            if(user!=null){
                //登录成功
                MainFrame mainFrame = new MainFrame();
                mainFrame.initMain(user);
                mainFrame.setVisible(true);
                LoginFrame.this.dispose();
            }else{
                JOptionPane.showMessageDialog(null,"登录失败，账户与密码不匹配","登录通知",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null,"登录失败，账户或密码为空","登录通知",JOptionPane.ERROR_MESSAGE);
        }
    }

    //注册按钮触发的事件
    private void registButtonActionPerformed(ActionEvent e) {
        //登录界面消失
        this.dispose();
        //注册界面显示
        new RegistFrame().setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label = new JLabel();
        usernameLabel = new JLabel();
        passwordLabel = new JLabel();
        textField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton();
        registButton = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setFont(new Font("Dialog", Font.PLAIN, 16));
        setTitle("\u767b\u5f55\u754c\u9762");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label ----
        label.setText("\u767b\u5f55\u754c\u9762");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 24));
        contentPane.add(label);
        label.setBounds(110, 20, 160, 35);

        //---- usernameLabel ----
        usernameLabel.setText("username");
        usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        usernameLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        contentPane.add(usernameLabel);
        usernameLabel.setBounds(55, 80, 95, usernameLabel.getPreferredSize().height);

        //---- passwordLabel ----
        passwordLabel.setText("password");
        passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        passwordLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        contentPane.add(passwordLabel);
        passwordLabel.setBounds(55, 125, 95, 22);
        contentPane.add(textField);
        textField.setBounds(175, 80, 145, textField.getPreferredSize().height);
        contentPane.add(passwordField);
        passwordField.setBounds(175, 125, 145, passwordField.getPreferredSize().height);

        //---- loginButton ----
        loginButton.setText("\u767b\u5f55");
        loginButton.addActionListener(e -> loginButtonActionPerformed(e));
        contentPane.add(loginButton);
        loginButton.setBounds(new Rectangle(new Point(85, 200), loginButton.getPreferredSize()));

        //---- registButton ----
        registButton.setText("\u6ce8\u518c");
        registButton.addActionListener(e -> registButtonActionPerformed(e));
        contentPane.add(registButton);
        registButton.setBounds(215, 200, 74, 24);

        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    //登录界面姓名回显
    public void initLogin(User user){
        textField.setText(user.getName());
    }

}

/*
 * Created by JFormDesigner on Wed Nov 18 15:04:46 CST 2020
 */

package com.igeek.javase.day13.jpanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author 11
 */
public class RegistPanel extends JPanel {

    private MyFrame my;

    public RegistPanel(MyFrame my) {
        this.my = my;
        initComponents();
    }

    //注册按钮
    private void registButtonActionPerformed(ActionEvent e) {
        String name = textField.getText();
        String pwd = new String(passwordField.getPassword());
        if(name!=null && !name.equals("") && pwd!=null && !pwd.equals("")){
            //插入数据
            User user = new User(name,pwd);
            my.dao.insert(user);
            //显示LoginPanel
            my.skip("login");
            //清空注册界面
            clearRegist();
            //回显登录页面数据
            my.loginPanel.initLogin(user);
        }else{
            JOptionPane.showMessageDialog(null,"注册失败，用户名或密码为空！");
        }

    }

    //重置按钮
    private void registButton2ActionPerformed(ActionEvent e) {
        clearRegist();
    }

    //清空界面
    private void clearRegist() {
        textField.setText("");
        passwordField.setText("");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label = new JLabel();
        nameLabel = new JLabel();
        pwdLabel = new JLabel();
        textField = new JTextField();
        passwordField = new JPasswordField();
        registButton = new JButton();
        registButton2 = new JButton();

        //======== this ========
        setLayout(null);

        //---- label ----
        label.setText("\u6ce8\u518c\u754c\u9762");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 24));
        add(label);
        label.setBounds(115, 35, 145, 40);

        //---- nameLabel ----
        nameLabel.setText("\u59d3  \u540d");
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        add(nameLabel);
        nameLabel.setBounds(60, 95, 75, nameLabel.getPreferredSize().height);

        //---- pwdLabel ----
        pwdLabel.setText("\u5bc6  \u7801");
        pwdLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pwdLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        add(pwdLabel);
        pwdLabel.setBounds(60, 145, 75, 22);
        add(textField);
        textField.setBounds(155, 95, 150, textField.getPreferredSize().height);
        add(passwordField);
        passwordField.setBounds(155, 145, 150, passwordField.getPreferredSize().height);

        //---- registButton ----
        registButton.setText("\u6ce8\u518c");
        registButton.addActionListener(e -> registButtonActionPerformed(e));
        add(registButton);
        registButton.setBounds(new Rectangle(new Point(90, 215), registButton.getPreferredSize()));

        //---- registButton2 ----
        registButton2.setText("\u91cd\u7f6e");
        registButton2.addActionListener(e -> registButton2ActionPerformed(e));
        add(registButton2);
        registButton2.setBounds(225, 215, 74, 24);

        setPreferredSize(new Dimension(400, 300));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label;
    private JLabel nameLabel;
    private JLabel pwdLabel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton registButton;
    private JButton registButton2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

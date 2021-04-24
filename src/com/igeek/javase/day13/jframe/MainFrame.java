/*
 * Created by JFormDesigner on Wed Nov 18 11:08:48 CST 2020
 */

package com.igeek.javase.day13.jframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

/**
 * @author 11
 */
public class MainFrame extends JFrame {
    public MainFrame() {
        initComponents();
    }

    //登出按钮
    private void button1ActionPerformed(ActionEvent e) {
        this.dispose();
        new LoginFrame().setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label = new JLabel();
        nameLabel = new JLabel();
        name = new JLabel();
        sexLabel = new JLabel();
        sex = new JLabel();
        hobbyLabel = new JLabel();
        addrLabel = new JLabel();
        hobby = new JLabel();
        address = new JLabel();
        logoutButton = new JButton();

        //======== this ========
        setTitle("\u4e3b\u754c\u9762");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label ----
        label.setText("\u4e3b \u754c \u9762");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 24));
        contentPane.add(label);
        label.setBounds(110, 15, 155, 32);

        //---- nameLabel ----
        nameLabel.setText("\u59d3  \u540d");
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        contentPane.add(nameLabel);
        nameLabel.setBounds(45, 65, 80, 22);

        //---- name ----
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        contentPane.add(name);
        name.setBounds(160, 65, 130, 22);

        //---- sexLabel ----
        sexLabel.setHorizontalAlignment(SwingConstants.CENTER);
        sexLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        sexLabel.setText("\u6027  \u522b");
        contentPane.add(sexLabel);
        sexLabel.setBounds(45, 105, 80, 22);

        //---- sex ----
        sex.setHorizontalAlignment(SwingConstants.CENTER);
        sex.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        contentPane.add(sex);
        sex.setBounds(155, 105, 130, 22);

        //---- hobbyLabel ----
        hobbyLabel.setHorizontalAlignment(SwingConstants.CENTER);
        hobbyLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        hobbyLabel.setText("\u7231  \u597d");
        contentPane.add(hobbyLabel);
        hobbyLabel.setBounds(45, 145, 80, 22);

        //---- addrLabel ----
        addrLabel.setHorizontalAlignment(SwingConstants.CENTER);
        addrLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        addrLabel.setText("\u5730  \u5740");
        contentPane.add(addrLabel);
        addrLabel.setBounds(45, 185, 80, 22);

        //---- hobby ----
        hobby.setHorizontalAlignment(SwingConstants.CENTER);
        hobby.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        contentPane.add(hobby);
        hobby.setBounds(145, 145, 205, 22);

        //---- address ----
        address.setHorizontalAlignment(SwingConstants.CENTER);
        address.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        contentPane.add(address);
        address.setBounds(145, 185, 130, 22);

        //---- logoutButton ----
        logoutButton.setText("\u767b  \u51fa");
        logoutButton.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(logoutButton);
        logoutButton.setBounds(new Rectangle(new Point(145, 235), logoutButton.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label;
    private JLabel nameLabel;
    private JLabel name;
    private JLabel sexLabel;
    private JLabel sex;
    private JLabel hobbyLabel;
    private JLabel addrLabel;
    private JLabel hobby;
    private JLabel address;
    private JButton logoutButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    //初始化界面
    public void initMain(User user){
        name.setText(user.getName());
        sex.setText(user.getSex().equals("boy")?"男":"女");
        String[] hobbys = user.getHobby().split("&");
        String hobby = Arrays.toString(hobbys);
        this.hobby.setText(hobby.substring(1,hobby.length()-1));
        address.setText(user.getAddress());
    }

}

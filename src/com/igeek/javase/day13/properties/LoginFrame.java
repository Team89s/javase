/*
 * Created by JFormDesigner on Wed Nov 18 10:20:44 CST 2020
 */

package com.igeek.javase.day13.properties;

import com.igeek.javase.day13.jframe.MainFrame;
import com.igeek.javase.day13.jframe.RegistFrame;
import com.igeek.javase.day13.jframe.User;
import com.igeek.javase.day13.jframe.UserDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author 11
 */
public class LoginFrame extends JFrame {

    private UserDao dao;
    ResourceBundle bundle;
    Locale locale;
    boolean flag = true;

    public static void main(String[] args) {
        new LoginFrame().setVisible(true);
    }

    public LoginFrame() {
        dao = new UserDao();
        //设置区域信息
        locale = new Locale("zh","CN");
        bundle = ResourceBundle.getBundle("msg",locale);
        initComponents();
        initBundle();
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

    //初始化界面
    private void initBundle() {
        label.setText(bundle.getString("login.title"));
        usernameLabel.setText(bundle.getString("login.username"));
        passwordLabel.setText(bundle.getString("login.password"));
        loginButton.setText(bundle.getString("login.loginBtn"));
        registButton.setText(bundle.getString("login.registBtn"));
    }

    //中英文切换按钮
    private void changeButtonMouseClicked(MouseEvent e) {
        if(flag){  // flag  true  中文
            locale = new Locale("en","US");
        }else{     // flag  false  英文
            locale = new Locale("zh","CN");
        }
        bundle = ResourceBundle.getBundle("msg",locale);
        flag=!flag;
        //初始化资源中文切换
        initBundle();
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
        changeButton = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setFont(new Font("Dialog", Font.PLAIN, 16));
        setTitle("\u767b\u5f55\u754c\u9762");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label ----
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 24));
        label.setText(" ");
        contentPane.add(label);
        label.setBounds(110, 20, 160, 35);

        //---- usernameLabel ----
        usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        usernameLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        contentPane.add(usernameLabel);
        usernameLabel.setBounds(55, 75, 95, 25);

        //---- passwordLabel ----
        passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        passwordLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        contentPane.add(passwordLabel);
        passwordLabel.setBounds(55, 125, 95, 22);
        contentPane.add(textField);
        textField.setBounds(175, 80, 145, textField.getPreferredSize().height);
        contentPane.add(passwordField);
        passwordField.setBounds(175, 125, 145, passwordField.getPreferredSize().height);

        //---- loginButton ----
        loginButton.addActionListener(e -> loginButtonActionPerformed(e));
        contentPane.add(loginButton);
        loginButton.setBounds(85, 200, 74, 24);

        //---- registButton ----
        registButton.addActionListener(e -> registButtonActionPerformed(e));
        contentPane.add(registButton);
        registButton.setBounds(215, 200, 74, 24);

        //---- changeButton ----
        changeButton.setText("\u4e2d\u82f1\u6587\u5207\u6362");
        changeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                changeButtonMouseClicked(e);
            }
        });
        contentPane.add(changeButton);
        changeButton.setBounds(new Rectangle(new Point(290, 20), changeButton.getPreferredSize()));

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
    private JButton changeButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    //登录界面姓名回显
    public void initLogin(User user){
        textField.setText(user.getName());
    }

}

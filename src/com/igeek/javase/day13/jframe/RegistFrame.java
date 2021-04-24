/*
 * Created by JFormDesigner on Wed Nov 18 09:20:21 CST 2020
 */

package com.igeek.javase.day13.jframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author 11
 */
public class RegistFrame extends JFrame {

    private UserDao dao;

    public RegistFrame() {
        dao = new UserDao();
        initComponents();
    }

    //注册按钮
    private void registButtonActionPerformed(ActionEvent e) {
        String name = nameTextField.getText();
        String pwd = new String(passwordField.getPassword());
        String repwd = new String(rePasswordField.getPassword());

        if(name!=null && !name.equals("") && pwd!=null && !pwd.equals("")){
            //校验密码与重复是否一致
            if(pwd.equals(repwd)){
                //收集表单数据，创建User对象

                String sex = "";
                //单选按钮
                if(boyRadioButton.isSelected()){
                    sex = "boy";
                }else if(girlRadioButton.isSelected()){
                    sex = "girl";
                }
                //复选框
                String hobby = "";
                if(codeCheckBox.isSelected()){
                    hobby+="code&";
                }
                if(musicCheckBox.isSelected()){
                    hobby+="music&";
                }
                if(gameCheckBox.isSelected()){
                    hobby+="game";
                }
                //下拉菜单
                String address = addrComboBox.getSelectedItem().toString();
                String email = emailTextField.getText();
                String content = comTextArea.getText();

                //封装User对象
                User user = new User(name,sex,pwd,hobby,address,content,email);
                //添加数据至集合中
                dao.insert(user);
                //显示登录界面
                LoginFrame loginFrame = new LoginFrame();
                loginFrame.setVisible(true);
                loginFrame.initLogin(user);
                //当前注册界面释放
                RegistFrame.this.dispose();
                //（清空当前注册界面信息）
            }else {
                //提示
                JOptionPane.showMessageDialog(null, "注册失败，密码与重复密码不一致", "注册通知", JOptionPane.WARNING_MESSAGE);
                //清空密码与重复密码框
                passwordField.setText("");
                rePasswordField.setText("");
            }
        }else{
            JOptionPane.showMessageDialog(null,"注册失败，姓名或密码为空","注册通知",JOptionPane.ERROR_MESSAGE);
        }
    }

    //重置按钮
    private void resetRegistButtonActionPerformed(ActionEvent e) {
        clearRegist();
    }

    /**
     * 初始化容器
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label = new JLabel();
        usernameLabel = new JLabel();
        sexLabel = new JLabel();
        pwdLabel = new JLabel();
        repwdLabel = new JLabel();
        emailLabel = new JLabel();
        hobbyLabel = new JLabel();
        addrLabel = new JLabel();
        comLabel = new JLabel();
        nameTextField = new JTextField();
        boyRadioButton = new JRadioButton();
        girlRadioButton = new JRadioButton();
        passwordField = new JPasswordField();
        rePasswordField = new JPasswordField();
        emailTextField = new JTextField();
        codeCheckBox = new JCheckBox();
        musicCheckBox = new JCheckBox();
        gameCheckBox = new JCheckBox();
        addrComboBox = new JComboBox<>();
        scrollPane = new JScrollPane();
        comTextArea = new JTextArea();
        registButton = new JButton();
        resetButton = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("\u6ce8\u518c\u754c\u9762");
        setResizable(false);
        setFont(new Font("Consolas", Font.PLAIN, 16));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label ----
        label.setText("\u6ce8\u518c\u754c\u9762");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 24));
        contentPane.add(label);
        label.setBounds(95, 10, 170, 40);

        //---- usernameLabel ----
        usernameLabel.setText("\u59d3  \u540d");
        usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        usernameLabel.setFont(usernameLabel.getFont().deriveFont(usernameLabel.getFont().getStyle() & ~Font.ITALIC, 16f));
        contentPane.add(usernameLabel);
        usernameLabel.setBounds(25, 65, 70, usernameLabel.getPreferredSize().height);

        //---- sexLabel ----
        sexLabel.setText("\u6027  \u522b");
        sexLabel.setHorizontalAlignment(SwingConstants.CENTER);
        sexLabel.setFont(sexLabel.getFont().deriveFont(sexLabel.getFont().getStyle() & ~Font.ITALIC, 16f));
        contentPane.add(sexLabel);
        sexLabel.setBounds(25, 105, 70, 17);

        //---- pwdLabel ----
        pwdLabel.setText("\u5bc6  \u7801");
        pwdLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pwdLabel.setFont(pwdLabel.getFont().deriveFont(pwdLabel.getFont().getStyle() & ~Font.ITALIC, 16f));
        contentPane.add(pwdLabel);
        pwdLabel.setBounds(25, 145, 70, 17);

        //---- repwdLabel ----
        repwdLabel.setText("\u91cd\u590d\u5bc6\u7801");
        repwdLabel.setHorizontalAlignment(SwingConstants.CENTER);
        repwdLabel.setFont(repwdLabel.getFont().deriveFont(repwdLabel.getFont().getStyle() & ~Font.ITALIC, 16f));
        contentPane.add(repwdLabel);
        repwdLabel.setBounds(25, 180, 70, 22);

        //---- emailLabel ----
        emailLabel.setText("\u90ae  \u7bb1");
        emailLabel.setHorizontalAlignment(SwingConstants.CENTER);
        emailLabel.setFont(emailLabel.getFont().deriveFont(emailLabel.getFont().getStyle() & ~Font.ITALIC, 16f));
        contentPane.add(emailLabel);
        emailLabel.setBounds(25, 225, 70, 17);

        //---- hobbyLabel ----
        hobbyLabel.setHorizontalAlignment(SwingConstants.CENTER);
        hobbyLabel.setFont(hobbyLabel.getFont().deriveFont(hobbyLabel.getFont().getStyle() & ~Font.ITALIC, 16f));
        hobbyLabel.setText("\u7231  \u597d");
        contentPane.add(hobbyLabel);
        hobbyLabel.setBounds(25, 270, 70, 17);

        //---- addrLabel ----
        addrLabel.setText("\u5730  \u5740");
        addrLabel.setHorizontalAlignment(SwingConstants.CENTER);
        addrLabel.setFont(addrLabel.getFont().deriveFont(addrLabel.getFont().getStyle() & ~Font.ITALIC, 16f));
        contentPane.add(addrLabel);
        addrLabel.setBounds(25, 310, 70, 17);

        //---- comLabel ----
        comLabel.setText("\u81ea\u6211\u8bc4\u4ef7");
        comLabel.setHorizontalAlignment(SwingConstants.CENTER);
        comLabel.setFont(comLabel.getFont().deriveFont(comLabel.getFont().getStyle() & ~Font.ITALIC, 16f));
        contentPane.add(comLabel);
        comLabel.setBounds(25, 350, 70, 17);

        //---- nameTextField ----
        nameTextField.setToolTipText("\u8bf7\u8f93\u5165\u59d3\u540d");
        contentPane.add(nameTextField);
        nameTextField.setBounds(120, 65, 155, 25);

        //---- boyRadioButton ----
        boyRadioButton.setText("\u7537");
        boyRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(boyRadioButton);
        boyRadioButton.setBounds(120, 105, 45, boyRadioButton.getPreferredSize().height);

        //---- girlRadioButton ----
        girlRadioButton.setText("\u5973");
        contentPane.add(girlRadioButton);
        girlRadioButton.setBounds(195, 105, 45, girlRadioButton.getPreferredSize().height);

        //---- passwordField ----
        passwordField.setEchoChar('*');
        contentPane.add(passwordField);
        passwordField.setBounds(125, 145, 150, passwordField.getPreferredSize().height);

        //---- rePasswordField ----
        rePasswordField.setEchoChar('*');
        contentPane.add(rePasswordField);
        rePasswordField.setBounds(125, 185, 150, 25);
        contentPane.add(emailTextField);
        emailTextField.setBounds(125, 225, 150, emailTextField.getPreferredSize().height);

        //---- codeCheckBox ----
        codeCheckBox.setText("code");
        codeCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(codeCheckBox);
        codeCheckBox.setBounds(130, 270, 60, codeCheckBox.getPreferredSize().height);

        //---- musicCheckBox ----
        musicCheckBox.setText("music");
        musicCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(musicCheckBox);
        musicCheckBox.setBounds(195, 270, 70, musicCheckBox.getPreferredSize().height);

        //---- gameCheckBox ----
        gameCheckBox.setText("game");
        gameCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(gameCheckBox);
        gameCheckBox.setBounds(270, 270, 70, gameCheckBox.getPreferredSize().height);

        //---- addrComboBox ----
        addrComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
            "\u6c5f\u82cf",
            "\u5b89\u5fbd",
            "\u6d59\u6c5f",
            "\u6cb3\u5317"
        }));
        contentPane.add(addrComboBox);
        addrComboBox.setBounds(new Rectangle(new Point(130, 305), addrComboBox.getPreferredSize()));

        //======== scrollPane ========
        {
            scrollPane.setViewportView(comTextArea);
        }
        contentPane.add(scrollPane);
        scrollPane.setBounds(130, 345, 145, 57);

        //---- registButton ----
        registButton.setText("\u6ce8\u518c");
        registButton.addActionListener(e -> registButtonActionPerformed(e));
        contentPane.add(registButton);
        registButton.setBounds(70, 430, 90, registButton.getPreferredSize().height);

        //---- resetButton ----
        resetButton.setText("\u91cd\u7f6e");
        resetButton.addActionListener(e -> resetRegistButtonActionPerformed(e));
        contentPane.add(resetButton);
        resetButton.setBounds(205, 430, 90, 24);

        contentPane.setPreferredSize(new Dimension(400, 500));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label;
    private JLabel usernameLabel;
    private JLabel sexLabel;
    private JLabel pwdLabel;
    private JLabel repwdLabel;
    private JLabel emailLabel;
    private JLabel hobbyLabel;
    private JLabel addrLabel;
    private JLabel comLabel;
    private JTextField nameTextField;
    private JRadioButton boyRadioButton;
    private JRadioButton girlRadioButton;
    private JPasswordField passwordField;
    private JPasswordField rePasswordField;
    private JTextField emailTextField;
    private JCheckBox codeCheckBox;
    private JCheckBox musicCheckBox;
    private JCheckBox gameCheckBox;
    private JComboBox<String> addrComboBox;
    private JScrollPane scrollPane;
    private JTextArea comTextArea;
    private JButton registButton;
    private JButton resetButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args) {
        new RegistFrame().setVisible(true);
    }

    //重置
    public void clearRegist(){
        nameTextField.setText("");
        passwordField.setText("");
        rePasswordField.setText("");
        emailTextField.setText("");
        addrComboBox.setSelectedIndex(0);
        boyRadioButton.setSelected(false);
        girlRadioButton.setSelected(false);
        codeCheckBox.setSelected(false);
        musicCheckBox.setSelected(false);
        gameCheckBox.setSelected(false);
        comTextArea.setText("");
    }
}

package com.company06;

import java.awt.*;
import javax.swing.*;

class BoxLayoutDemo extends JFrame {
    private JLabel jLabel1, jLabel2, jLabel3;
    private JButton jConnect;
    private JTextField jUID;
    private JPasswordField jPwd, jConfirmPwd;

    BoxLayoutDemo() {
        super("用户注册界面");
        jLabel1 = new JLabel("用 户 名：  ");
        jLabel2 = new JLabel("密      码：  ");
        jLabel3 = new JLabel("确认密码：");
        jConnect = new JButton("注册");
        jUID = new JTextField(15);
        jPwd = new JPasswordField(15);
        jConfirmPwd = new JPasswordField(15);
        Box userName = Box.createHorizontalBox();
        // 创建Box容器的水平格式
        Box password = Box.createHorizontalBox();
        Box confirmPassword = Box.createHorizontalBox();
        Box submitButton = Box.createHorizontalBox();
        userName.add(jLabel1);
        // 在Box容器中加入组件
        userName.add(jUID);
        password.add(jLabel2);
        password.add(jPwd);
        confirmPassword.add(jLabel3);
        confirmPassword.add(jConfirmPwd);
        submitButton.add(jConnect);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        // 设置BoxLayout 布局
        this.add(userName);
        this.add(password);
        this.add(confirmPassword);
        this.add(submitButton);
        userName.setVisible(true);
        password.setVisible(true);
        confirmPassword.setVisible(true);
        submitButton.setVisible(true);
        this.setSize(240, 150);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new BoxLayoutDemo();
    }
}
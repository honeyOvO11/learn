package com.company02;

import java.awt.*;
import java.awt.event.*;

public class UserLogin extends Frame implements ActionListener {
    // 创建用户名标签lName，并设置标签文本为“用户名”
    Label lName = new Label("用户名");
    // 创建用户名文本框tName
    TextField tName = new TextField();
    // 创建密码标签lPass，并设置标签文本为“密码”
    Label lPass = new Label("密码");
    // 创建密码文本框tPass
    TextField tPass = new TextField();
    // 创建确定按钮btnConfirm，并设置标签文本为“确定”
    Button btnConfirm = new Button("Enter");

    public UserLogin(String title) {
        // 调用父类构造方法，设置窗体标题
        super(title);
        // 设置窗体大小
        setSize(300, 200);
        // 取消窗体的布局管理器
        setLayout(null);
        // 设置用户名标签与文本框的位置与大小
        lName.setBounds(60, 50, 70, 20);
        tName.setBounds(135, 50, 100, 20);
        // 设置密码标签与文本框的位置与大小
        lPass.setBounds(60, 90, 70, 20);
        tPass.setBounds(135, 90, 100, 20);
        tPass.setEchoChar('*');
        // 设置确定按钮的位置和大小
        // 设置密码文本框的回显字符
        btnConfirm.setBounds(110, 140, 70, 20);
        // 为确定按钮注册事件侦听器
        btnConfirm.addActionListener(this);
        // 将组件添加到窗体中
        add(lName);
        add(tName);
        add(lPass);
        add(tPass);
        add(btnConfirm);
        // 设置窗体的位置与可见性
        setLocation(200, 100);
        setVisible(true);
    }

    // 事件处理方法
    public void actionPerformed(ActionEvent e) {
        // 获取事件对象
        Object ob = e.getSource();
        // 如果事件对象为btnConfirm，则输出用户名和密码
        if (ob == btnConfirm) {
            System.out.println("用户名：" + tName.getText());
            System.out.println("密码：" + tPass.getText());
        }
    }
}

package com.company04;

import java.awt.*;
import java.awt.event.*;

public class EventAdapter extends Frame {
    private TextArea txtApp = new TextArea("这是文本区");
    private Button btnApp = new Button("这是按钮");
    // 创建鼠标事件侦听器
    MouseEventHandler handler = new MouseEventHandler();

    public EventAdapter(String title) {
        super(title);
        // 为窗体注册窗口事件侦听器
        addWindowListener(new WindowAdapter() {
            // 重写windowClosing()方法，关闭当前窗口
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        // 设置窗体的大小，取消其布局管理器，并使窗体在屏幕上居中放置
        setSize(300, 200);
        setLayout(null);
        setLocationRelativeTo(null);
        // 设置文本区的字体、位置和大小
        txtApp.setFont(new Font("宋体", Font.PLAIN, 16));
        txtApp.setBounds(10, 40, 280, 100);
        // 为文本区注册鼠标事件侦听器
        txtApp.addMouseListener(handler);
        // 设置按钮的位置和大小
        btnApp.setBounds(120, 150, 60, 30);
        // 为按钮注册鼠标事件侦听器
        btnApp.addMouseListener(handler);
        // 将文本区和按钮添加到窗体中
        add(txtApp);
        add(btnApp);
        // 显示窗体
        setVisible(true);
    }

    public static void main(String args[]) {
        new EventAdapter("Adapter Demo");
    }

    // 定义继承MouseAdapter适配器的事件侦听器类
    class MouseEventHandler extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            // 检测事件源是文本区还是按钮
            if (e.getSource() == txtApp) {
                String s = "鼠标所单击的位置为文本区！\n";
                s += "鼠标所处的位置为:\nX=" + e.getX() + ";Y=" + e.getY();
                // 用红色字体显示鼠标单击的位置坐标
                txtApp.setForeground(Color.RED);
                txtApp.setText(s);
            }
            if (e.getSource() == btnApp) {
                String s = "鼠标所单击的位置为按钮！\n";
                s += "鼠标所处的位置为:\nX=" + e.getX() + ";Y=" + e.getY();
                // 用蓝色字体显示鼠标单击的位置坐标
                txtApp.setForeground(Color.BLUE);
                txtApp.setText(s);
            }
        }
    }
}
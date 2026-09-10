package com.company06;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class TextEditor extends JFrame implements ActionListener {
    JMenuBar mainMenubar; // 声明菜单栏
    JMenu file;
    // 声明主菜单项
    JMenuItem nw;
    JMenuItem op;
    JMenuItem cl;
    JMenuItem sf;
    JMenuItem ex;
    JTextArea tx;

    // 声明新建文件子菜单项
    // 声明打开文件子菜单项
    // 声明关闭文件子菜单项
    // 声明保存文件子菜单项
    // 声明退出子菜单项
    // 声明文本区
    public TextEditor(String title) {
        super(title);
        // 调用父类构造方法
        setSize(400, 400); // 设置窗体大小
        setLocationRelativeTo(null); // 使窗体在屏幕上居中放置
        menuinit();
        // 调用构建与处理菜单的方法
        tx = new JTextArea();
        add(tx);
        setVisible(true);
    }

    // 定义菜单构建与处理方法
    void menuinit() {
        // 创建文本区对象
        // 将文本区对象放入窗体
        // 使窗体可见
        mainMenubar = new JMenuBar(); // 创建主菜单栏
        file = new JMenu("文件");
        // 创建主菜单项
        // 创建各子菜单项
        nw = new JMenuItem("新建文件");
        op = new JMenuItem("打开文件");
        cl = new JMenuItem("关闭文件");
        sf = new JMenuItem("保存文件");
        ex = new JMenuItem("退出");
        // 将各子菜单项加入到主菜单项中
        file.add(nw);
        file.add(op);
        file.add(cl);
        file.add(sf);
        file.add(ex);
        mainMenubar.add(file);
        // 将主菜单项加入到主菜单栏
        setJMenuBar(mainMenubar); // 为窗体设置主菜单
        // 为各子菜单项注册事件侦听器
        nw.addActionListener(this);
        op.addActionListener(this);
        cl.addActionListener(this);
        sf.addActionListener(this);
        ex.addActionListener(this);
    }

    // 重写ActionEvent事件处理方法
    public void actionPerformed(ActionEvent e) {
        Object ob = e.getSource();
        // 获取事件对象
        JFileChooser f = new JFileChooser(); // 创建文件选择器对象
        // 选择"新建文件"或"关闭文件"子菜单项
        if ((ob == nw) || (ob == cl)) {
            tx.setText("");
            // 清空文本区
        } else if (ob == op) { // 选择"打开文件"子菜单项
            // 弹出具有自定义按钮的文件选择器对话框
            f.showOpenDialog(this);
            try {
                // 定义StringBuffer 对象s
                StringBuffer s = new StringBuffer();
                // 创建FileReader对象in，参数为在文件选择器中选中的文件
                FileReader in = new FileReader(f.getSelectedFile());
                // 读取文件内容，将其追加到s中
                while (true) {
                    int b = in.read();
                    if (b == -1)
                        break;
                    s.append((char) b);
                }
                tx.setText(s.toString()); // 将文件内容显示在文本区
                in.close();
                // 关闭文件
            } catch (Exception e1) {
            }
        } else if (ob == sf) {
            // 选择"保存文件"子菜单项
            f.showSaveDialog(this); // 显示文件选择对话框
            try {
                // 创建FileWriter对象，其参数为选择的文件
                FileWriter out = new FileWriter(f.getSelectedFile());
                out.write(tx.getText()); // 将文本区内容写入文件
                out.close();
                // 关闭文件
            } catch (Exception e2) {
            }
        } else if (ob == ex) // 选择"退出"子菜单项
            System.exit(0);
        // 退出系统
    }

    public static void main(String[] args) {
        new TextEditor("简易文本编辑器");
    }
}
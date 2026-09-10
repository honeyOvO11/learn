package com.company05;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StudentManager extends JFrame implements ActionListener {
    JTextField tNo = new JTextField(10);
    // 创建学号文本框tNo
    JTextField tName = new JTextField(10); // 创建姓名文本框tName
    // 创建性别单选钮组groupSex，包含两个单选钮
    ButtonGroup groupSex = new ButtonGroup();
    JRadioButton man = new JRadioButton("男", true);
    JRadioButton woman = new JRadioButton("女");
    // 创建出生年份下拉列表框cbAge
    JComboBox<String> cbAge = new JComboBox<String>();
    JButton btnOK = new JButton("添加");
    // 创建添加按钮btnOK
    JButton btnDelete = new JButton("删除"); // 创建删除按钮btnDelete
    JButton btnQuit = new JButton("退出"); // 创建退出按钮btnQuit
    JLabel lNo = new JLabel("学号");
    // 创建学号标签lNo
    JLabel lName = new JLabel("姓名");
    JLabel lSex = new JLabel("性别");
    JLabel lAge = new JLabel("出生年份");
    JTable table;
    // 创建姓名标签lName
    // 创建性别标签lSex
    // 创建出生年份标签lAge
    // 声明表格table
    DefaultTableModel model; // 创建 DefaultTableModel 类对象 model

    public StudentManager(String title) {
        super(title);
        // 调用父类构造方法
        setSize(400, 400);
        // 设置组件位置和大小
        // 设置窗体的大小
        lNo.setBounds(50, 20, 100, 20);
        tNo.setBounds(150, 20, 100, 20);
        lName.setBounds(50, 50, 100, 20);
        tName.setBounds(150, 50, 100, 20);
        lSex.setBounds(50, 80, 100, 20);
        man.setBounds(150, 80, 60, 20);
        woman.setBounds(250, 80, 60, 20);
        lAge.setBounds(50, 110, 100, 20);
        cbAge.setBounds(150, 110, 100, 20);
        // 向groupSex 组添加单选钮man和woman
        groupSex.add(man);
        groupSex.add(woman);
        // 设置下拉列表框选项，添加年份
        cbAge.addItem("1990");
        cbAge.addItem("1989");
        cbAge.addItem("1988");
        cbAge.addItem("1987");
        cbAge.addItem("1986");
        cbAge.addItem("1985");
        cbAge.addItem("1984");
        // 设置3个按钮位置和大小
        btnOK.setBounds(80, 160, 60, 20);
        btnDelete.setBounds(150, 160, 60, 20);
        btnQuit.setBounds(220, 160, 60, 20);
        Container c = getContentPane(); // 创建 Container 类对象 c
        JPanel panel = new JPanel();
        // 创建面板对象panel
        panel.setLayout(null);
        // 将各组件添加到面板panel中
        panel.add(tNo);
        panel.add(tName);
        panel.add(man);
        panel.add(woman);
        panel.add(cbAge);
        panel.add(lNo);
        panel.add(lName);
        panel.add(lSex);
        panel.add(lAge);
        panel.add(btnOK);
        panel.add(btnDelete);
        panel.add(btnQuit);
        // 取消panel的布局管理器
        String[] colName = { "学号", "姓名", "性别", "出生年份" };
        // 创建model
        model = new DefaultTableModel(colName, 0);
        // 创建table，并使用model保存table数据
        table = new JTable(model);
        // 创建滚动面板scrollPane，将table添加到scrollPane中
        JScrollPane scrollPane = new JScrollPane(table);
        // 设置窗体的布局管理器为GridLayout，分为2行1列
        c.setLayout(new GridLayout(2, 1));
        c.add(panel);
        c.add(scrollPane);
        setLocationRelativeTo(null);
        setVisible(true);
        // 将panel添加到窗体中
        // 将scrollPane 添加到窗体中
        // 使窗体在屏幕上居中放置
        // 设置窗体可见
        // 为三个按钮注册事件侦听器
        btnOK.addActionListener(this);
        btnDelete.addActionListener(this);
        btnQuit.addActionListener(this);
    }

    // 重写ActionEvent事件处理方法
    public void actionPerformed(ActionEvent e) {
        Object ob = e.getSource(); // 获取事件对象
        if (ob == btnQuit) {
            // 单击退出按钮
            System.exit(0);
        } else if (ob == btnOK) {
            // 退出系统
            // 单击确认按钮
            // 根据选择获取性别
            String sex;
            if (man.isSelected())
                sex = "男";
            else
                sex = "女";
            String[] stuInfo = { tNo.getText(), tName.getText(),
                    sex, cbAge.getSelectedItem().toString() };
            model.addRow(stuInfo);
            // 将信息添加到model中
            tNo.setText("");
            tName.setText("");
            man.setSelected(true);
            // 清空学号文本框
            // 清空姓名文本框
            // 选中man单选钮
        } else if (ob == btnDelete) { // 单击删除按钮
            if (table.getSelectedRow() < 0)
                // 弹出一个错误提示对话框
                JOptionPane.showMessageDialog(null, "请在表格中选择要删除的选项",
                        "警告", JOptionPane.WARNING_MESSAGE);
            else
                // 删除选择项
                model.removeRow(table.getSelectedRow());
        }
    }

    public static void main(String[] args) {
        new StudentManager("学生信息管理");
    }
}
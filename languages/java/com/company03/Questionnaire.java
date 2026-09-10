package com.company03;

import java.awt.*;
import java.awt.event.*;

public class Questionnaire extends Frame implements ActionListener {
    // 创建姓名文本框，文本框宽度为10
    TextField name = new TextField(10);
    CheckboxGroup sex = new CheckboxGroup();
    // 创建性别单选钮组
    Checkbox man = new Checkbox("男", true, sex); // 创建男单选钮
    Checkbox woman = new Checkbox("女", false, sex); // 创建女单选钮
    // 创建年龄文本框，初始值为20，文本框宽度为4
    TextField age = new TextField("20", 4);
    Choice nativeplace = new Choice(); // 创建籍贯下拉式菜单
    Checkbox like1 = new Checkbox("读书");
    // 创建读书复选框
    Checkbox like2 = new Checkbox("上网");
    // 创建上网复选框
    Checkbox like3 = new Checkbox("体育活动");// 创建体育活动复选框
    List website = new List(4);
    // 创建喜欢的网站列表，显示4行
    Button btnOK = new Button("确认");
    // 创建确认按钮
    Button btnCancel = new Button("取消"); // 创建取消按钮
    Button btnQuit = new Button("退出");
    // 创建退出按钮
    // 创建标签
    Label label = new Label("个人信息调查表");
    Label lName = new Label("姓名");
    Label lSex = new Label("性别");
    Label lAge = new Label("年龄");
    Label lNativeplace = new Label("籍贯");
    Label lLike = new Label("爱好");
    Label lWebsite = new Label("喜欢的网站");

    public Questionnaire(String title) {
        super(title);
        // 调用父类构造方法
        setSize(400, 400);
        setLayout(null);
        // 设置组件的位置和大小
        // 设置窗体的大小
        // 取消窗体的布局管理器
        label.setBounds(150, 50, 100, 20);
        lName.setBounds(50, 100, 40, 20);
        name.setBounds(90, 100, 100, 20);
        lSex.setBounds(230, 100, 40, 20);
        man.setBounds(270, 100, 60, 20);
        woman.setBounds(330, 100, 60, 20);
        lAge.setBounds(50, 150, 40, 20);
        age.setBounds(90, 150, 50, 20);
        // 个人信息调查表标签
        // 姓名标签
        // 姓名文本框
        // 性别标签
        // 男单选钮
        // 女单选钮
        // 年龄标签
        // 年龄文本框
        lNativeplace.setBounds(230, 150, 40, 20);// 籍贯标签
        nativeplace.setBounds(270, 150, 60, 20); // 籍贯选项框
        // 设置下拉菜单选项，添加城市名
        nativeplace.add("北京");
        nativeplace.add("上海");
        nativeplace.add("天津");
        nativeplace.add("重庆");
        nativeplace.add("广东");
        nativeplace.add("河南");
        // 设置组件的位置和大小
        lLike.setBounds(50, 200, 40, 20);
        like1.setBounds(90, 200, 60, 20);
        like2.setBounds(150, 200, 60, 20);
        like3.setBounds(210, 200, 100, 20);
        // 爱好标签
        // 读书标签
        // 上网标签
        // 体育活动标签
        lWebsite.setBounds(50, 250, 80, 20); // 喜欢的网站标签
        website.setBounds(130, 250, 100, 60); // 喜欢的网站列表
        // 设置列表选项，添加网站名
        website.add("新浪");
        website.add("搜狐");
        website.add("网易");
        website.add("淘宝");
        website.add("赶集网");
        website.add("新华网");
        // 设置组件的位置和大小
        btnOK.setBounds(110, 330, 50, 20);
        // 确认按钮
        btnCancel.setBounds(180, 330, 50, 20); // 取消按钮
        btnQuit.setBounds(250, 330, 50, 20);
        // 退出按钮
        // 将各组件添加到窗体中
        add(label);
        add(lName);
        add(name);
        add(lSex);
        add(man);
        add(woman);
        add(lAge);
        add(age);
        add(lNativeplace);
        add(nativeplace);
        add(lLike);
        add(like1);
        add(like2);
        add(like3);
        add(lWebsite);
        add(website);
        add(btnOK);
        add(btnCancel);
        add(btnQuit);
        setLocationRelativeTo(null);
        setVisible(true);
        // 使窗体在屏幕上居中放置
        // 设置窗体可见
        // 为三个按钮注册事件侦听器
        btnOK.addActionListener(this);
        btnCancel.addActionListener(this);
        btnQuit.addActionListener(this);
    }

    // 重写事件处理方法
    public void actionPerformed(ActionEvent e) {
        Object ob = e.getSource();
        // 获取事件对象
        // 单击退出按钮
        // 退出系统
        // 单击确认按钮
        if (ob == btnQuit) {
            System.exit(0);
        } else if (ob == btnOK) {
            // 输出信息
            System.out.println("姓名：" + name.getText());
            System.out.println("性别：" + sex.getSelectedCheckbox().getLabel());
            System.out.println("年龄：" + age.getText());
            System.out.println("籍贯：" + nativeplace.getSelectedItem());
            // 如果复选框被选中，则返回其标签，否则将字符串设置为空
            String s1 = like1.getState() ? like1.getLabel() + " " : "";
            String s2 = like2.getState() ? like2.getLabel() + " " : "";
            String s3 = like3.getState() ? like3.getLabel() + " " : "";
            System.out.println("爱好：" + s1 + s2 + s3);
            System.out.println("喜欢的网站：" + website.getSelectedItem());
        } else if (ob == btnCancel) {
            name.setText("");
            // 单击取消按钮
            // 清空姓名文本框
            sex.setSelectedCheckbox(man); // 选中“男”单选钮
            age.setText("20");
            // 设置年龄文本框为20
            // 取消爱好复选框
            like1.setState(false);
            like2.setState(false);
            like3.setState(false);
            // 取消所选喜欢的网站
            website.deselect(website.getSelectedIndex());
        }
    }

    public static void main(String[] args) {
        new Questionnaire("个人信息");
    }
}
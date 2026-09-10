package com.company01;

/*
* 在主函数中直接创建框架对象的方式
* 优点：简洁直接，无需额外定义类，代码量少；
* 缺点：主函数臃肿，所有逻辑（配置、组件、事件）堆叠。
* 适用场景：1）小型 Demo、快速原型验证；
*2）仅需显示简单窗口，无复杂功能；
*3）新手学习框架API的基础使用。
*/
import java.awt.*;

public class FramePanelTest {
    public static void main(String[] args) {
        // 创建Frame类对象frame，设置标题为“TextEditor”
        Frame frame = new Frame("TextEditor");
        frame.setVisible(true); // 调用setVisible()方法，设置窗体可见
        frame.setSize(240, 150); // 调用setSize()方法，设置窗体大小
        frame.setLayout(null); // 调用setLayout()方法，取消布局管理器
        Panel pan = new Panel();
        // 创建Panel类对象pan
        pan.setSize(100, 100);
        // 调用setSize()方法，设置面板大小
        // 调用setBackground()方法，设置面板背景颜色为红色
        pan.setBackground(Color.red);
        frame.add(pan);
        // 调用add()方法把面板添加到窗体中
    }
}
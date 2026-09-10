package com.company01;

/*
* 优点：结构清晰，初始化、组件、事件分离封装；
* 缺点：需额外定义子类，少量增加代码量。
* 框架子类方式：1）中大型应用程序；
*2）需要自定义窗口功能（如绘图、事件处理）；
*3）多个地方复用相同窗口；
*5）追求代码可维护性和扩展性。
*/
import java.awt.*;

// 定义FramePanel类，继承Frame类
public class FramePanel extends Frame {
    // 定义有参构造方法，传入标题
    public FramePanel(String title) {
        super(title);
        // 调用父类的构造方法
        setVisible(true); // 调用setVisible()方法，设置窗体可见
        setSize(240, 150); // 调用setSize()方法，设置窗体大小
        setLayout(null); // 调用setLayout()方法，取消布局管理器
        // setBackground(Color.blue); // 窗体背景颜色为蓝色
    }
}
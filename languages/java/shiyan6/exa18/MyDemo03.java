package shiyan6.exa18;

import javax.swing.JOptionPane;

/**
 * 1.javax.swing 包中包含很多创建 Java 图形用户界面应用程序所必需的类。
 * 将 JOptionPane 类引入当前程序，方便在程序中调用相关方法，实现相关输入输出功能。
 * 2.调用类 JOptionPane 的 showInputDialog 方法显示“输入”对话框。
 * showInputDialog 方法的参数为提示信息，用以提示用户输人相关内容。
 * 在文本框中输入相关字符信息后，单击“确定”按钮或按 Enter 键可以把文本框中的字
 * 符信息返回给 Java 程序。
 * 3.调用类 JOptionPane 的 showMessageDialog 方法,打开“消息”对话框显示结果信息。
 * 这个方法包含两个参数，参数之间用逗号分隔。
 * 第一个参数表示对话框的父窗口对象，当使用关键字 null 时，表示对话框的父窗口不
 * 存在，对话框将直接显示在计算机的显示器屏幕上;
 * 第二个参数为对话框中要显示的信息，类型为字符串。
 */
public class MyDemo03 {
    public static void main(String[] args) {
        String s1 = JOptionPane.showInputDialog("输入一个整数");
        int a = Integer.parseInt(s1);
        String s2 = JOptionPane.showInputDialog("输入一个小数");
        double b = Double.parseDouble(s2);
        // 处理数据
        double c = a + b;
        // 输出结果
        // 图形化输出方案
        JOptionPane.showMessageDialog(null, "结果为：" + a + "+" + b + "=" + c);

    }
}
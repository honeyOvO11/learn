package shiyan6.exa18;

/**
* 根据运行界面是以图形化要素为主，还是以文本字符为主，可分为两种主要类型：
* GUI 应用程序(GUI Application)
* 控制台应用程序(Console Application)
*/
import java.io.*;// 以便在程序中调用相关的类和方法

public class MyDemo01 {
    // 输入输出异常，由虚拟机自行处理
    public static void main(String args[]) throws IOException {
        // 输入数据
        // 控制台输入方案
        System.out.println("输入一个整数：");
        byte t[] = new byte[10];
        System.in.read(t); // 用于获取用户从键盘输入的数据。
        String s1 = new String(t);
        int a = Integer.parseInt(s1.trim());// 去除空格
        System.out.println("输入一个小数：");
        System.in.read(t);
        String s2 = new String(t);
        double b = Double.parseDouble(s2.trim());
        // 处理数据
        double c = a + b;
        // 输出结果
        // 控制台输出方案
        System.out.println("计算的结果为：" + c);
    }
}

package shiyan6.exa19;

import java.io.*;

public class Circle {
    /* 键盘输入半径，求圆的周长和面积 */
    public static void main(String[] args) throws IOException {
        // 定义常量PI
        final double PI = 3.14;
        // 定义变量
        byte buf[] = new byte[50];
        double r, girth, area;
        // 输入圆的半径
        System.out.println("请输入一个圆的半径：");
        System.in.read(buf);
        String str = new String(buf);
        r = Double.parseDouble(str.trim());
        // 计算周长和面积
        girth = 2 * PI * r;
        area = PI * r * r;
        // 输出结果
        System.out.println("圆的周长为：" + girth);
        System.out.println("圆的面积为：" + area);
    }
}

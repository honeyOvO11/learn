package shiyan6.exa19;

import javax.swing.JOptionPane;

public class exc {
    /* 键盘输入长和宽，计算矩形的周长和面积 */
    public static void main(String args[]) {
        // 定义变量
        String s;
        double length, width, girth, area;
        // 输入矩形的长和宽
        s = JOptionPane.showInputDialog("输入矩形的长：");
        length = Double.parseDouble(s);
        s = JOptionPane.showInputDialog("输入矩形的宽：");
        width = Double.parseDouble(s);
        // 计算周长和面积
        girth = (length + width) * 2;
        area = length * width;
        // 输出计算结果
        JOptionPane.showMessageDialog(null, "周长为：" + girth + "\n" + "面积为："
                + area);
    }
}

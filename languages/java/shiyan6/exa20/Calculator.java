package shiyan6.exa20;

import javax.swing.JOptionPane;

public class Calculator {
    public static void main(String[] args) {
        // 定义所需变量
        String temp;
        double oneprice, twoprice, totalprice;
        // 输入两种商品的价格
        temp = JOptionPane.showInputDialog("请输入饮料的价格");
        oneprice = Double.parseDouble(temp);
        temp = JOptionPane.showInputDialog("请输入面包的价格：");
        twoprice = Double.parseDouble(temp);
        // 计算两种商品的总价格
        totalprice = oneprice + twoprice;
        // 输出计算的总价格
        JOptionPane.showMessageDialog(null,
                "饮料价格：" + oneprice + "元\n" + "面包价格：" + twoprice + "元\n" + "商品总价格：" + totalprice + "元");
    }
}
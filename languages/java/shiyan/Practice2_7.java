import java.util.Scanner;

public class Practice2_7 {
    public static void main(String[] args) {
        System.out.print("请输入一个整数：");
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        boolean b1 = true, b2 = false;
        boolean y = a % 2 == 1 ? b1 : b2; // 判断输入的数是奇数还是偶数
        System.out.println("整数为：" + (y ? "奇数" : "偶数"));
        // 如果结果为真求余数为1是奇数，否则反之
        s.close(); // 关闭s
    }
}// 192+13=205行
import java.util.Scanner;

public class Practice2_8_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("输入整数密码: ");
        int pwd = sc.nextInt();
        System.out.print("输入位移位数(1-5): ");
        int shift = sc.nextInt();

        // 加密：左移
        int encrypted = pwd << shift;
        System.out.println("加密后: " + encrypted);

        // 解密：右移
        int decrypted = encrypted >> shift;
        System.out.println("解密后: " + decrypted);

        sc.close();
    }
}// 为Practice2_8的简化版；260+22=282行
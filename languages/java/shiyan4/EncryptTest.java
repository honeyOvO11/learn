package shiyan4;

import java.util.Scanner;

class Encrypt {
    public static int encrypt(int number) {
        // 分解各位数字
        int digit1 = number / 1000; // 第一位
        int digit2 = (number / 100) % 10; // 第二位
        int digit3 = (number / 10) % 10; // 第三位
        int digit4 = number % 10; // 第四位
        // 每位数字加5后除以10取余数
        digit1 = (digit1 + 5) % 10;
        digit2 = (digit2 + 5) % 10;
        digit3 = (digit3 + 5) % 10;
        digit4 = (digit4 + 5) % 10;
        // 交换第一位和第四位
        int temp = digit1;
        digit1 = digit4;
        digit4 = temp;
        // 交换第二位和第三位
        temp = digit2;
        digit2 = digit3;
        digit3 = temp;
        // 组合成新的数字
        return digit1 * 1000 + digit2 * 100 + digit3 * 10 + digit4;
    }
}

public class EncryptTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("请输入一个四位整数: ");
            int number = scanner.nextInt();

            if (number < 1000 || number > 9999) {
                System.out.println("输入的不是四位整数！");
                return;
            }
            int encryptedNumber = Encrypt.encrypt(number);
            System.out.println("加密后的数字是: " + encryptedNumber);
        } finally {
            // 确保无论如何都会执行关闭操作
            scanner.close();
        }
    }
}// 551+45=596
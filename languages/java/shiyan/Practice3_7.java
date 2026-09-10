import java.util.Scanner;

public class Practice3_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("欢迎使用飞机行李托运计费系统");
        System.out.print("请输入行李重量(公斤): ");
        double weight = scanner.nextDouble();
        if (weight < 0) {
            System.out.println("重量不能为负数！");
        } else if (weight <= 20) {
            System.out.println("行李重量" + weight + "公斤，免费托运");
        } else if (weight <= 30) {
            double fee = (weight - 20) * 5;
            System.out.printf("行李重量%.1f公斤，托运费: %.2f元\n", weight, fee);
        } else if (weight <= 40) {
            double fee = 10 * 5 + (weight - 30) * 10;
            System.out.printf("行李重量%.1f公斤，托运费: %.2f元\n", weight, fee);
        } else if (weight <= 50) {
            double fee = 10 * 5 + 10 * 10 + (weight - 40) * 15;
            System.out.printf("行李重量%.1f公斤，托运费: %.2f元\n", weight, fee);
        } else {
            System.out.println("行李重量超过50公斤，不允许个人携带！");
        }
        scanner.close();
    }
}
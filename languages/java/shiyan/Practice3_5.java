import java.util.Scanner;

public class Practice3_5 {
    public static void main(String[] args) {
        int a, i;
        Scanner scan = new Scanner(System.in);
        for (i = 1; i <= 10; i++) {
            System.out.print("请输入一个整数：");
            a = scan.nextInt();
            if (a % 9 == 0) {
                System.out.println(a);
                break;
            }
        }
        if (i > 10)
            System.out.print("不存在");
        scan.close();
    }
}
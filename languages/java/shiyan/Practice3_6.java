public class Practice3_6 {
    public static void main(String[] args) {
        System.out.println("所有的水仙花数：");

        for (int num = 100; num < 1000; num++) {
            int hundreds = num / 100; // 获取百位数
            int tens = (num / 10) % 10; // 获取十位数
            int units = num % 10; // 获取个位数

            // 计算各位数字的立方和
            int sum = hundreds * hundreds * hundreds
                    + tens * tens * tens
                    + units * units * units;

            // 判断是否为水仙花数
            if (sum == num) {
                System.out.println(num);
            }
        }
    }
}

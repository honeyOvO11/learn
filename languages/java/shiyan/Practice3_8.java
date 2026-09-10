public class Practice3_8 {
    public static void main(String[] args) {
        System.out.println("百马百担问题的所有可能解：");
        System.out.println("大马\t中马\t小马");

        // 遍历所有可能的大马数量
        for (int big = 0; big <= 100 / 3; big++) {
            // 遍历所有可能的中马数量
            for (int medium = 0; medium <= (100 - big) / 2; medium++) {
                int small = 100 - big - medium; // 小马数量
                // 检查担数是否等于100
                if (3 * big + 2 * medium + 0.5 * small == 100) {
                    // 确保小马数量是偶数（因为两匹小马驮一担）
                    if (small % 2 == 0) {
                        System.out.println(big + "\t" + medium + "\t" + small);
                    }
                }
            }
        }
    }
}
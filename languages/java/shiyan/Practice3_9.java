import java.util.Scanner;

public class Practice3_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入你拥有的金币数量: ");
        int totalCoins = scanner.nextInt();
        int maxLife = 0;
        int bestFairyGrass = 0;
        int bestGalaxyShuttle = 0;
        // 计算最多能买多少仙女草(20金币每个)
        int maxFairyGrass = totalCoins / 20;
        // 遍历所有可能的购买组合
        for (int fg = 0; fg <= maxFairyGrass; fg++) {
            // 剩余金币
            int remainingCoins = totalCoins - fg * 20;
            // 用剩余金币买尽可能多的银河梭(16金币每个)
            int gs = remainingCoins / 16;

            // 计算总生命力
            int totalLife = fg * 30 + gs * 20;

            // 检查是否为更好的方案
            if (totalLife > maxLife) {
                maxLife = totalLife;
                bestFairyGrass = fg;
                bestGalaxyShuttle = gs;
            }
        }
        System.out.println("最佳购买方案:");
        System.out.println("仙女草: " + bestFairyGrass + " 个");
        System.out.println("银河梭: " + bestGalaxyShuttle + " 个");
        System.out.println("总增加生命力: " + maxLife);
        scanner.close();
    }
}
public class Practice3_10 {
    public static void main(String[] args) {
        // 从可能的最小值开始尝试（因为至少要剩下11头牛）
        // 计算分母的最小公倍数不是必须的，我们可以直接从某个合理值开始尝试
        int n = 2520; // 4,5,6,7,8,9的最小公倍数，这是一个合理的起点

        while (true) {
            // 计算所有儿子的分配总和
            int totalGiven = n / 4 + n / 5 + n / 6 + n / 7 + n / 8 + n / 9;

            // 计算剩余
            int remaining = n - totalGiven;

            // 检查是否满足条件
            if (remaining == 11) {
                System.out.println("国王的遗产中共有 " + n + " 头牛");
                break;
            }
        }
    }
}// 471+20=491
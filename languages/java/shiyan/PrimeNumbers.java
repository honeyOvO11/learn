// 定义类名（必须与文件名一致）
public class PrimeNumbers {
    // 主方法：程序入口
    public static void main(String[] args) {
        int num = 2; // 从2开始检查素数
        int count = 0; // 计数器，用于控制每行输出5个素数

        // 外层循环：遍历2到100的所有数字
        while (num <= 100) {
            boolean isPrime = true; // 假设当前数字是素数（初始值为true）
            int i = 2; // 内层循环的除数，从2开始

            // 内层循环：检查num是否为素数
            // 优化：只需检查到num的平方根（数学原理：若存在大于平方根的因数，则必有小于平方根的因数）
            while (i <= Math.sqrt(num)) {
                // 如果num能被i整除，则不是素数
                if (num % i == 0) {
                    isPrime = false;
                    break; // 发现非素数，立即结束内层循环
                }
                i++; // 尝试下一个除数
            }

            // 如果是素数，则输出并管理格式
            if (isPrime) {
                System.out.print(num + " "); // 输出素数（不换行）
                count++; // 计数器+1

                // 每输出5个素数换行
                if (count % 5 == 0) {
                    System.out.println(); // 换行
                }
            }
            num++; // 检查下一个数字
        }
    }// 第37行总计37行
}
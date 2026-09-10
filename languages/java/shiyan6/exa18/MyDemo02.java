package shiyan6.exa18;

import java.util.Scanner;

/**
 * Scanner scan = new Scanner(System.in);
 * 是 Java 中用于从标准输入（通常是键盘）读取用户输入的代码。
 * 它的主要功能如下：
 * 创建 Scanner 对象：
 * new Scanner(System.in)创建了一个 Scanner 类的实例，用于处理输入流。
 * 指定输入源：
 * System.in 表示标准输入流，通常对应键盘输入，这意味着 Scanner 将从键盘读取用户输
 * 入的数据。
 * 提供多种输入方法：
 * 通过创建的 scan 对象，可以使用 Scanner 类提供的一系列方法读取不同类型的输入。
 * 例如：
 * nextInt()：读取整数
 * nextDouble()：读取双精度浮点数
 * nextLine()：读取一行文本
 * next()：读取一个单词（以空格为分隔符）
 * 使用完毕后，建议调用 scan.close()关闭 Scanner，以释放相关资源。
 */
public class MyDemo02 {
    /* 两数求和 */
    public static void main(String args[]) {
        try (// 输入数据
                // 控制台输入方案
                Scanner scan = new Scanner(System.in)) {
            System.out.println("输入一个整数：");
            int a = scan.nextInt();
            System.out.println("输入一个小数：");
            double b = scan.nextDouble();
            // 处理数据
            double c = a + b;
            // 输出结果
            // 控制台输出方案
            System.out.println("计算的结果为：" + c);
            // 使用完毕后，建议调用 scan.close()关闭 Scanner，以释放相关资源。
        }
    }
}
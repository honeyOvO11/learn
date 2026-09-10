package com.company.computer04;

/**
 * 方法体
 * 修饰符 返回值类型 方法名(参数1，参数2，…)throws 异常类1, 异常类2... {
 *
 * }
 * throws 关键字声明该方法有可能发生的异常，这样调用者在调用方法时，
 * 就明确地知道该方法有异常，并且必须在程序中对异常进行处理，否则编译无法通过。
 */
public class Example04 {
    public static void main(String[] args) {
        // 下面的代码定义了一个try…catch语句用于捕获异常
        try {
            int result = divide(4, 2); // 调用divide()方法
            System.out.println("4÷2=" + result);
        } catch (Exception e) {
            e.printStackTrace();
            // 对捕获到的异常进行处理
            // 打印捕获的异常信息
        }
    }

    // 实现了两个整数相除，并使用throws关键字声明抛出异常
    public static int divide(int x, int y) throws Exception {
        int result = x / y; // 定义变量result记录两个数相除的结果
        return result;
    }// 将结果返回
}

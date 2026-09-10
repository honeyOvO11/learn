package com.company.computer02;

/**
 * 异常处理，就是指程序在出现问题时依然可以正确的执行完。
 * 在Java应用程序中，异常处理机制分为：
 * 1）抛出异常
 * 当一个方法出现错误引发异常时，方法创建异常对象并交付运行时系统；
 * 异常对象中包含了异常类型和异常出现时的程序状态等异常信息。
 * 运行时系统负责寻找处置异常的代码并执行。
 * 2）捕捉异常。
 * 在方法抛出异常之后，运行时系统将转为寻找合适的异常处理器（exceptionhandler）。
 * 潜在的异常处理器是异常发生时依次存留在调用栈中的方法的集合。
 * 通过try-catch 语句捕获异常，这两个语句必须同时使用。其一般语法形式为：
 * try {
 * // 可能会发生异常的程序代码
 * } catch (异常类型 异常的变量名1){
 * // 捕获并处置try抛出的异常类型1
 * } catch (异常类型 异常的变量名2){
 * // 捕获并处置try抛出的异常类型2
 * }
 */
public class Example02 {
    public static void main(String[] args) {
        try { // try 监控区域
            int result = divide(4, 0); // 调用 divide()方法，第2个参数为0
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println(e.toString());
        }
        System.out.println("程序继续会执行下去-------");
    }

    // 下面的方法实现了两个整数相除
    public static int divide(int x, int y) {
        int result = x / y; // 定义一个变量result记录两个数相除的结果
        return result; // 将结果返回
    }
}
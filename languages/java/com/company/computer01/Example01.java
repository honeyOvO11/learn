package com.company.computer01;

/**
 * 异常指程序运行过程中出现的非正常现象:
 *
 * 例如文件找不到、用户输入错误、除数为零、数组下标越界等。
 * 异常是一个事件，它发生在程序运行期间，干扰了正常的指令流程。
 * Java 通过API中Throwable类的众多子类描述各种不同的异常。
 * Java 异常都是对象，是Throwable子类的实例，描述了出现在一段编码中的错误条件。
 * 当条件生成时，错误将引发异常。
 * Throwable：有两个重要的子类:
 *
 * Error（错误）：是指程序无法处理的错误，表示运行应用程序中较严重问题。
 *
 *
 * Exception（异常）：是程序本身可以处理的异常，常分两大类：
 * 运行时异常和非运行时异常（编译异常）。程序中应当尽可能去处理这些异常。
 */
public class Example01 {
    public static void main(String[] args) {
        int result = divide(4, 0);
        // 调用divide()方法，第2个参数为0
        System.out.println(result);
    }

    // 下面的方法实现了两个整数相除
    public static int divide(int x, int y) {
        int result = x / y; // 定义一个变量result记录两个数相除的结果
        return result;
        // 将结果返回
    }
}
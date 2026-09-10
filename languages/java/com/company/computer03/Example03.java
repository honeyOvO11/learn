package com.company.computer03;

/**
 * try-catch-finally 语句:
 * try 块：用于捕获异常。
 * 其后可接零个或多个catch块，如果没有catch块，则必须跟一个finally块。
 * catch 块：用于处理try捕获到的异常。
 * finally 块：无论是否捕获或处理异常，finally块里的语句都会被执行。
 * 当在try块或catch块中遇到return语句时，finally语句块将在方法返回之前被执行。
 * try-catch-finally 语句的一般语法形式为：
 * try{
 * // 可能会发生异常的程序代码
 * }catch(Type1 id1){
 * // 捕获并处理try抛出的异常类型Type1
 * }catch(Type2 id2){
 * // 捕获并处理try抛出的异常类型Type2
 * }finally{
 * // 无论是否发生异常，都将执行的语句块
 * }
 * 在以下4种特殊情况下，finally块不会被执行：
 * 1）在finally语句块中发生了异常；
 * 2）在前面的代码中用了System.exit()退出程序。
 * 3）程序所在的线程死亡。
 * 4）关闭CPU。
 * try、catch、finally 语句块的执行顺序：
 * 1）当try没有捕获到异常时：try语句块中的语句逐一被执行，程序将跳过catch语句
 * 块，执行finally语句块和其后的语句；
 * 2）当try语句块里的某条语句出现异常时，而没有处理此异常的catch语句块时，此异
 * 常将会抛给JVM处理，finally语句块里的语句还是会被执行，但finally语句块后的语
 * 句不会被执行；
 * 3）当try捕获到异常，catch语句块里有处理此异常的情况：在try语句块中是按照顺
 * 序来执行的，当执行到某一条语句出现异常时，程序将跳到catch语句块，并与catch
 * 语句块逐一匹配，找到与之对应的处理程序，其他的catch语句块将不会被执行，而try
 * 语句块中，出现异常之后的语句也不会被执行，catch语句块执行完后，执行finally语
 * 句块里的语句，最后执行finally语句块后的语句。
 */
public class Example03 {
    public static void main(String[] args) {
        try {
            int result = divide(4, 0); // 调用 divide()方法，第 2个参数为0
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println(e.toString());
            return;
        } finally {
            System.out.println("程序继续会执行下去-------");
        }
    }

    // 下面的方法实现了两个整数相除
    public static int divide(int x, int y) {
        int result = x / y; // 定义一个变量result记录两个数相除的结果
        return result;
    }
    // 将结果返回
}
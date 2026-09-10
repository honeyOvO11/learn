package com.company.computer05;

/**
 * throw 总是出现在函数体中，用来抛出一个Throwable类型的异常。
 * 程序会在throw语句后立即终止，它后面的语句执行不到，
 * 然后在包含它的所有try块中（可能在上层调用函数中）从里向外寻找含有与其匹配的
 * catch 子句的try块。
 */
public class Example05 {
    public static void main(String[] args) {
        // 下面的代码定义了一个try…catch语句用于捕获异常
        int age = -1;
        try {
            printAge(age);
        } catch (Exception e) {// 对捕获到的异常进行处理
            System.out.println("捕获的异常信息为：" + e.getMessage());
        }
    }

    public static void printAge(int age) throws Exception {
        if (age <= 0) {
            // 对业务逻辑进行判断，当输入年龄为负数时抛出异常
            throw new Exception("输入的年龄有误，必须是正整数！");
        } else {
            System.out.println("此人年龄为：" + age);
        }
    }
}
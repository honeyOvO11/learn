package com.company.com15;

/**
 * Lambda 表达式:简化代码书写
 * 1.使用前提
 * 必须是接口。接口中只能有一个抽象方法,对使用接口中方法的一种优化。
 * 2.使用格式
 * （数据类型 参数名1,数据类型 参数名2----）->{方法体 }
 * （）：代表的是要执行接口中对应的那个重写方法。如果方法中有参数，那么就需要传递参数。
 * ->：固定格式。作用是将小括号中的参数传递给后面的大括号方法体中。
 * {}：代表的是实现接口中那个抽象方法后的方法体。
 * 匿名内部类：没有名字的特殊局部内部类
 * 格式：
 * new 类名 或 接口名(){重写方法}
 * 使用场景：作为方法的参数传递
 * 传统实现方式：
 * 1.编写实现类
 * 2.重写抽象方法
 * 3.创建实现类对象
 * 4.将实现类对象作为方法的参数传递
 */
public class LambdaDemo01 {
    public static void main(String[] args) {
        useInter(new Inter() {
            @Override
            public void show(String str) {
                System.out.println(str);
            }
        });
        System.out.println("------------");
        useInter(str -> System.out.println(str));
    }

    // 使用Inter接口的方法
    public static void useInter(Inter i) {
        i.show("hello");
    }
}

interface Inter {
    public abstract void show(String str);
}
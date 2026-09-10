package com.company.com08;

/**
* TreeSet 集合：底层是二叉树实现。可以对存入的元素进行排序。
* 排序方式一：自然排序。要求集合中元素的类必须要实现Comparable接口，
* 重写compareTo编写比较的条件。
* Java 中大部分的类都实现了Comparable接口，并默认实现了接口中的CompareTo()方法，
* 如Integer、Double 和 String等。
* 规则:从小到大
*/
import java.util.TreeSet;

public class TreeSetDemo01 {
    public static void main(String[] args) {
        TreeSet<Integer> ts1 = new TreeSet<>();
        ts1.add(5);
        ts1.add(3);
        ts1.add(2);
        ts1.add(1);
        ts1.add(4);
        System.out.println(ts1);// [1, 2, 3, 4, 5]
        TreeSet<String> ts2 = new TreeSet<>();
        ts2.add("Tom");
        ts2.add("Candy");
        ts2.add("Baby");
        ts2.add("David");
        for (Object o : ts2) {
            System.out.println(o);
        }
    }
}
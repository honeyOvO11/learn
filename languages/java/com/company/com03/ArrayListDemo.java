package com.company.com03;

import java.util.ArrayList;

/**
 * ArrayList 集合看作一个长度可变的数组。
 * ArrayList 特点：
 * 底层是数组结构实现的，数组有索引、查询速度比较快。
 * 在增加或删除指定位置的元素时，会创建新的数组，增删比较慢。
 * 使用场景：如果大量的数据经常做查询的操作，优先使用ArrayList
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        // 向集合中添加元素，有序，可重复
        list.add("张三");
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
        System.out.println(list);
        // 获取集合中元素的个数
        System.out.println("集合的长度：" + list.size());
        // 取出并打印指定位置的元素
        System.out.println("第 2 个元素是：" + list.get(1));
        list.remove(3);
        // 删除索引为3的元素
        System.out.println("删除索引为 3 的元素:" + list);
        list.set(1, "李四 2");
        // 替换索引为1的元素为李四2
        System.out.println("替换索引为 1 的元素为李四2:" + list);
    }
}
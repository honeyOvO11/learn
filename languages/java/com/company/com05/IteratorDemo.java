package com.company.com05;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        // 第1种方法：
        System.out.println(list);
        // 第2种方法：for循环
        for (int i = 0; i < list.size(); i++) {
            // list 集合有索引，可以用for来遍历
            String s = list.get(i);
            System.out.print(s + " ");
        }
        System.out.println();
        // 第3种方法：增强for循环（foreach循环）
        for (String str : list) {
            System.out.print(str + " ");
            str = "qq";
            // str 是第三方变量，用来依次接收集合中的数据，改变不会影响原集合中值
        }
        System.out.println();
        // 第4种方法：迭代器是通用的遍历方式
        Iterator<String> it = list.iterator(); // 1.获取迭代器对象
        while (it.hasNext()) { // 2.判断迭代器中是否还有下一个元素
            Object str = it.next();// 3.获取迭代器中下一个元素
            System.out.print(str + " ");
        }
    }
}

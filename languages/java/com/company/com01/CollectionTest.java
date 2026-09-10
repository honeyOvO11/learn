package com.company.com01;

import java.util.*;

public class CollectionTest {
    public static void main(String[] args) {
        // 泛型：约束集合可以存储数据的类型
        Collection<String> c1 = new ArrayList<>();
        // boolean add(Object o) 添加元素
        c1.add("aa");
        c1.add("bb");
        System.out.println(c1);
        // boolean addAll(Collection c) 将指定集合中所有元素添加到当前集合
        Collection<String> c2 = new ArrayList<>();
        c2.add("cc");
        c2.add("dd");
        c1.addAll(c2);
        System.out.println(c1);
        // boolean contains(Object o) 判断集合是否包含指定元素
        System.out.println(c1.contains("aa"));
        System.out.println(c1.contains("aaa"));
        // boolean containsAll(Collection c) 判断集合中是否包含指定集合所有元素
        System.out.println(c1.containsAll(c2));
        // int size() 获取集合的长度
        System.out.println(c1.size());
    }
}
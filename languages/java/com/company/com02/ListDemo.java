package com.company.com02;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("bb");
        list.add("cc");
        // void add(int index,Object element) 将指定索引位置添加元素
        list.add(0, "aa");
        System.out.println(list);
        List<String> list2 = new ArrayList<>();
        list2.add("dd");
        list2.add("cc");
        // addAll(int index,Collection c) 将指定集合元素添加到当前集合指定索引位置
        list.addAll(0, list2);
        System.out.println(list);
        // Object get(int index) 获取指定索引处的元素
        System.out.println(list.get(0));
        // Object remove(int index) 删除指定索引处的元素，返回被删除的元素
        System.out.println(list.remove(0));
        System.out.println(list);
        // Object set(int index, Object obj) 修改指定索引处元素，返回被修改的元素
        System.out.println(list.set(0, "qq"));
        System.out.println(list);
    }
}
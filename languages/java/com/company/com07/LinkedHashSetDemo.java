package com.company.com07;

/**
* HashSet 集合存储的元素是无序的
* 想让元素的存取顺序一致，可使用LinkedHashSet类，是HashSet的子类
* 与LinkedList 一样，它也使用双向链表来维护内部元素的关系。
*/
import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetDemo {
    public static void main(String[] args) {
        LinkedHashSet set = new LinkedHashSet();
        set.add("张三");
        // 向该Set集合中添加字符串
        set.add("李四");
        set.add("王五");
        Iterator it = set.iterator(); // 获取 Iterator 对象
        while (it.hasNext()) {
            // 通过while循环，判断集合中是否有元素
            Object obj = it.next();
            System.out.println(obj);
        }
    }
}
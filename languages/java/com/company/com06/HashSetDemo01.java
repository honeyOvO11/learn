package com.company.com06;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Hashset集合: 没有索引、不能存储重复元素、元素唯一存取无序
 * 元素唯一的原理：
 * 1、根据对象的哈希值(调用hashCode()计算)来计算存储位置
 * 2、判断当前位置时候有数据
 * 2.1、没有：直接存储
 * 2.2、有：调用equanl()方法比较属性值
 * 2.2.1、属性值相同：不存储
 * 2.2.2、属性值不同：以链表结构存储
 **/
public class HashSetDemo01 {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();
        hs.add("张三");
        hs.add("张三");
        hs.add("李四");
        hs.add("王五");
        hs.add("赵六");
        /*
         * for(int i = 0; i<hs.size;i++) {
         * hs.get(i); 没有索引，报错，不能用for循环遍历
         * }
         */
        for (String s : hs) {
            System.out.print(s + " ");
        }
        System.out.println();
        Iterator<String> it = hs.iterator(); // 获取迭代器对象
        while (it.hasNext()) {
            String str = it.next();
            System.out.print(str + " ");
        }
    }
}

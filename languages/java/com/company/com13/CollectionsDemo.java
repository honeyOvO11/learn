package com.company.com13;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Collections 集合工具类：
 * static <T> boolean addAll(Collection<? super T> c, T...elements) 将所有指定元
 * 素添加到指定集合c中
 * static void reverse(List list) 反转指定List集合中元素的顺序
 * static void shuffle(List list) 对 List集合中的元素进行随机排序
 * static void sort(List list) 根据元素的自然顺序对List集合中的元素进行排序
 * static void swap(List list,int i,int j) 将指定List集合中角标i处元素和j处元
 * 素进行交换
 * 使用二分法搜索指定对象在List集合中的索引，查找的List集合中的元素必须是有序的
 * static int binarySearch(List list,Object key)
 * static Object max(Collection col) 根据元素的自然顺序，返回给定集合中最大的元素
 * static Object min(Collection col) 根据元素的自然顺序，返回给定集合中最小的元素
 * 用一个新值newVal替换List集合中所有的旧值oldVal
 * static boolean replaceAll(List list,Object oldVal,Object newVal)
 */
public class CollectionsDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        // static <T> boolean addAll(Collection<? super T> c, T...elements)
        // 将所有指定元素添加到指定集合c中
        Collections.addAll(list, "a", "b", "c", "d");
        System.out.println(list);
        // static void reverse(List list)反转指定 List 集合中元素的顺序
        Collections.reverse(list);
        System.out.println(list);
        // static void shuffle(List list)对 List 集合中的元素进行随机排序
        Collections.shuffle(list);
        System.out.println(list);
        // sort(List list)根据元素的自然顺序对List集合中的元素进行排序
        Collections.sort(list);
        System.out.println(list);
        // swap(List list,int i,int j) 将指定 List集合中角标i处元素和j处元素进行交换
        // Collections.swap(list,2,3);
        // System.out.println(list);
        // 使用二分法搜索指定对象在List集合中的索引，查找的List集合中的元素必须是有序的
        // static int binarySearch(List list,Object key)
        int index = Collections.binarySearch(list, "c");
        System.out.println(index);
        // static Object max(Collection col) 根据元素的自然顺序，返回给定集合中最大的元素
        String max = Collections.max(list);
        System.out.println(max);
        // static Object min(Collection col) 根据元素的自然顺序，返回给定集合中最小的元素
        String min = Collections.min(list);
        System.out.println(min);
        // 用一个新值newVal替换List集合中所有的旧值oldVal
        // static boolean replaceAll(List list,Object oldVal,Object newVal)
        Collections.replaceAll(list, "b", "f");
        System.out.println(list);
    }
}
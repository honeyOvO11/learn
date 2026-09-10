package com.company.com14;

import java.util.Arrays;

/**
 * Arrays 数组工具类：
 * void sort(); 数组排序；
 * String toString(); 打印数组
 * int binarySearch(Object[] a, Object key) 用二分查找法，查找元素，返回索引位置
 * int[] copyOfRange(int[] original,int from,int to) 复制数组元素到一个新数组中
 * void fill(Object[] a, Object val) 传入的元素替换数组中所有的元素
 */
public class ArraysDemo {
    public static void main(String[] args) {
        int[] arr = { 10, 50, 30, 20, 40, 60 };
        // void sort(); 数组排序
        Arrays.sort(arr);
        // String toString(); 打印数组
        System.out.println(Arrays.toString(arr));
        // int binarySearch(Object[] a, Object key)
        // 使用二分查找法，查找元素，返回索引位置
        int index = Arrays.binarySearch(arr, 50);
        System.out.println(index);
        // int[] copyOfRange(int[] original, int from, int to)
        // 复制数组元素到一个新数组中
        int[] arr2 = Arrays.copyOfRange(arr, 1, 3); // 不包含结束索引
        System.out.println(Arrays.toString(arr2));
        // void fill(Object[] a, Object val) 传入的元素替换数组中所有的元素
        Arrays.fill(arr2, 88);
        System.out.println(Arrays.toString(arr2));
    }
}
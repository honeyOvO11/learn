package com.company.com15;

import java.util.Comparator;
import java.util.TreeSet;

public class LambdaDemo02 {
    public static void main(String[] args) {
        /*
         * TreeSet<Integer> ts = new TreeSet<>(new Comparator<Integer>() {
         * //ALT+回车用 Lambda 替换
         * 
         * @Override
         * public int compare(Integer o1, Integer o2) {
         * return o2-o1;
         * }
         * });
         */
        TreeSet<Integer> ts = new TreeSet<>((o1, o2) -> o2 - o1);
        // 多个参数，数据类型可以不写，如(Integer o1, Integer o2)->{return o2-o1;}
        // 可以简化写法
        ts.add(5);
        ts.add(2);
        ts.add(3);
        ts.add(1);
        ts.add(4);
        System.out.println(ts);
    }
}
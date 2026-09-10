package com.company.com08;

import java.util.TreeSet;

/**
 * TreeSet集合：底层是二叉树实现。可以进行元素的排序
 * 自定义类：要求存储的元素类必须实现Comparable接口，并重写compareTo()方法。
 */
public class TreeSetDemo02 {
    public static void main(String[] args) {
        TreeSet<Student> ts = new TreeSet<>();
        Student s1 = new Student("aa", 25);
        Student s2 = new Student("aa", 25);
        Student s3 = new Student("bb", 23);
        Student s4 = new Student("ba", 23);
        Student s5 = new Student("cc", 24);
        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        ts.add(s5);
        // System.out.println(ts);
        for (Student student : ts) {
            System.out.println(student);
        }
    }
}
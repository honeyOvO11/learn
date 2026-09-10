package com.company.com12;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        // 方法1：自然排序升序，String类已经重写compareTo方法了。
        TreeMap<String, String> tm = new TreeMap<>();
        tm.put("hm002", "张三");
        tm.put("hm003", "李四");
        tm.put("hm001", "王五");
        tm.put("hm004", "赵六");
        System.out.println(tm);
        // 方法1：重写compareTo方法降序排序。
        TreeMap<Student, String> tm1 = new TreeMap<>();
        Student s1 = new Student("张三", 23);
        Student s2 = new Student("李四", 25);
        Student s3 = new Student("王五", 24);
        tm1.put(s1, "基础班");
        tm1.put(s2, "基础班");
        tm1.put(s3, "就业班");
        System.out.println(tm1);
        // 方法2：定制排序，通过Comparator升序排序,
        /*
         * TreeMap<Teacher,String> tm2 = new TreeMap<>();
         * Teacher t1 = new Teacher("张三",23);
         * Teacher t2 = new Teacher("李四",25);
         * Teacher t3 = new Teacher("王五",24);
         * tm2.put(t1,"基础班");
         * tm2.put(t2,"基础班");
         * tm2.put(t3,"就业班");
         * System.out.println(tm2);
         */
        TreeMap<Teacher, String> tm2 = new TreeMap<>(new Comparator<Teacher>() {
            @Override
            public int compare(Teacher t1, Teacher t2) {
                return t1.getAge() - t2.getAge();
            }
        });
        Teacher t1 = new Teacher("张三", 23);
        Teacher t2 = new Teacher("李四", 25);
        Teacher t3 = new Teacher("王五", 24);
        tm2.put(t1, "基础班");
        tm2.put(t2, "基础班");
        tm2.put(t3, "就业班");
        // System.out.println(tm2);
        Set keySet = tm2.keySet();
        Iterator it = keySet.iterator();
        while (it.hasNext()) {
            Object key = it.next();
            Object value = tm2.get(key); // 获取每个键所对应的值
            System.out.println(key + "--" + value);
        }
    }
}
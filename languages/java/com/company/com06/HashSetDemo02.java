package com.company.com06;

import java.util.HashSet;

public class HashSetDemo02 {
    public static void main(String[] args) {
        // 注意:如果是自定义类型的对象，保存到HashSet集合，
        // 必须要重写hashCode()和equals()方法。
        HashSet<Student> hs = new HashSet<>();
        Student s1 = new Student("张三", 23);
        Student s2 = new Student("张三", 23);
        Student s3 = new Student("李四", 24);
        Student s4 = new Student("王五", 25);
        hs.add(s4);
        hs.add(s1);
        hs.add(s2);
        hs.add(s3);
        for (Student student : hs) {
            System.out.println(student);
        }
    }
}
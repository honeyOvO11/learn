package com.company.com06;

/**
*Set 集合去重原理:
*1.调用对象的hashCode方法，得到哈希值
*如果哈希值不同，则直接存储
*2.当哈希值相同时，才会调用equals方法
*比较结果为false则存储
*比较结果是true才会当成重复元素，不存
*如何把内容相同视为相同元素:
*解决方案:
*
*重写hashCode和equals 方法
**/
import java.util.Objects;

public class Student /* extends Object */ {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "名字：" + name + ", 年龄=" + age;
    }
}
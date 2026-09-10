package com.company.com08;

/**
 * TreeSet集合：底层是二叉树实现。可以对存入的元素进行排序。
 * 排序方式一：自然排序。要求集合中元素的类必须要实现Comparable接口，
 * 重写compareTo编写比较的条件。
 * Java中大部分的类都实现了Comparable接口，并默认实现了接口中的CompareTo()方法，
 * 如Integer、Double和String 等,规则:从小到大。
 * 对自定义对象进行排序?
 * 自定义类：要求存储的元素类必须实现Comparable接口，并重写compareTo()方法。
 * 可不可以从大到小?
 */
public class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name=" + name + ", age=" + age;
    }

    @Override
    public int compareTo(Student o) { // 排序方式一：自然排序
        // 排序规则：按照年龄升序
        int result = this.age - o.getAge();// o.getAge()-this.age 降序
        /*
         * 编写排序规则返回值特点：
         * 1.返回的是负数（小）、向左存
         * 2.返回的是0、不存储
         * 3.返回的是正数（大）、向右存
         */
        // 次要条件：如果年龄相同、按照姓名排序
        if (result == 0) {
            result = this.name.compareTo(o.getName());
        }
        return result;
    }
}
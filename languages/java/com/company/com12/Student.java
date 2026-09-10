package com.company.com12;

/**
 * 自定义类：要求存储的元素类必须实现Comparable接口，并重写compareTo()方法。
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
    public int compareTo(Student o) {
        // 排序规则：按照年龄升序
        int result = o.getAge() - this.age; // this.age-o.getAge();升序
        // 次要条件：如果年龄相同、按照姓名排序
        if (result == 0) {
            result = this.name.compareTo(o.getName());
        }
        return result;
    }
}
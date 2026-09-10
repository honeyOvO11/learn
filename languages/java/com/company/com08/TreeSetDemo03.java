package com.company.com08;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 排序方式二（推荐）：比较器排序。需要在TreeSet集合的构造方法中,传递比较器接口
 * 的实现类对象。编写排序条件！
 *
 * TreeSet 排序:
 * 自然排序:
 * 自定义类 实现 Comparable接口重写compareTo方法并指定排序规则
 * 定制排序:（推荐）
 * 通过TreeSet的有参构造，传递Comparator对象并指定排序规则
 * 注意:定制排序优先级大于自然排序
 */
public class TreeSetDemo03 {
    public static void main(String[] args) {
        TreeSet<Teacher> ts = new TreeSet<Teacher>(new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                // 按照年龄降序排序
                int result = o2.getAge() - o1.getAge();
                return result;
            }
        });
        Teacher t1 = new Teacher("张三", 23);
        Teacher t2 = new Teacher("王五", 25);
        Teacher t3 = new Teacher("李四", 26);
        Teacher t4 = new Teacher("赵四", 24);
        ts.add(t1);
        ts.add(t2);
        ts.add(t3);
        ts.add(t4);
        // System.out.println(ts);
        for (Teacher teacher : ts) {
            System.out.println(teacher);
        }
    }
}
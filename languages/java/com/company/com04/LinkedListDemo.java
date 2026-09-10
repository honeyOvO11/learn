package com.company.com04;
import java.util.LinkedList;
/**
* LinkedList 集合内部维护了一个双向循环链表，链表中的每一个元素都使用引用的方式
记录它的前一个元素和后一个元素，
* 从而可以将所有的元素彼此连接起来。当插入一个新元素时，只需要修改元素之间的引
44
用关系即可，删除一个节点也是如此。
* 正因为这样的存储结构，所以LinkedList集合增删效率非常高。
*/
// 添加元素到开头
public class LinkedListDemo {
public static void main(String[] args) {
LinkedList<String> list = new LinkedList<>();
list.add("张三");
list.add("李四");
list.add("王五");
System.out.println(list);
list.addFirst("赵六");
System.out.println(list);
list.addLast("周七");
System.out.println(list);
String first = list.getFirst(); // 获取第一个元素并返回
System.out.println(first);
String last = list.getLast(); // 获取最后一个元素并返回
System.out.println(last);
System.out.println(list.removeFirst()); // 删除第一个元素并返回
System.out.println(list.removeLast()); // 删除最后一个元素并返回
System.out.println(list);
}
}
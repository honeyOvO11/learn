package com.company.com11;

import java.util.LinkedHashMap;
import java.util.Set;

public class LinkedHashMapTest {
    public static void main(String[] args) {
        // HashMap<String,String> hm = new HashMap<>();//存储无序
        // 注意：如果想要保证元素的存取顺序，可以使用LinkedHashMap集合。
        LinkedHashMap<String, String> hm = new java.util.LinkedHashMap<>();
        hm.put("s01", "张三");
        hm.put("s02", "李四");
        hm.put("s03", "王五");
        hm.put("s04", "赵六");
        Set<String> keys = hm.keySet();
        for (String key : keys) {
            String value = hm.get(key);
            System.out.println(key + "," + value);
        }
    }
}
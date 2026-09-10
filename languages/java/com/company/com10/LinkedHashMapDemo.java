package com.company.com10;

import java.util.*;

/**
 * Map遍历:
 * map集合是不能直接使用增强for和普通for，迭代器.
 * Map集合遍历方式:
 * 方法一：Set keySet() 获取所有的键、保存到Set集合
 *
 * 1、map 双列集合不能直接遍历
 *
 *
 * 2、调用keySet()获取所有的键，保存到Set集合中，
 * 遍历Set集合可获得所有的键,配合get()方法就可获得键对应的值。
 * 方法二：Set<Map.Entry<K,V>>entrySet()获取所有键值对对象、保存到Set集合
 *
 * entrySet()方法会将每一对数据，封装成一个一个Entry对象，
 *
 *
 * 然后保存在Set集合中，然后遍历Set集合，得到Entry对象，
 * 通过getKey()和getValue()方法获得键和值。
 * 第三种：forEach（BiConsumer）JDK8版本新增的遍历的方法。
 *
 * forEach（）；
 * 第四种：values（）；获取map集合中所有的值，返回到一个Collection集合中。
 *
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        // 创建HashMap 集合对象
        // Map<String,String> map = new HashMap<>();
        HashMap<String, String> map = new HashMap<>();
        // void put(Object key, Object value) 添加一对数据（键值映射）
        map.put("hm001", "张三");// Map 集合中的键是唯一的、值可以重复
        map.put("hm002", "李四");
        map.put("hm003", "王五");
        map.put("hm004", "赵六");
        // 第一种方式：keySet()方法
        // Set keySet() 获取所有的键、保存到Set集合
        Set<String> keys = map.keySet(); // map 双列集合不能直接遍历，两种方式
        for (String key : keys) {
            String value = map.get(key);
            System.out.println(key + "," + value);
        }
        System.out.println("----------------------");
        /*
         * // 第二种方式：entrySet()方法
         * // Set<Map.Entry<K,V>>entrySet()
         * 获取所有键值对对象、保存到Set集合
         * Set<Map.Entry<String, String>> entries = map.entrySet();
         * for (Map.Entry<String, String> entry : entries) {
         * String key = entry.getKey();
         * String value = entry.getValue();
         * System.out.println(key+","+value);
         * }
         * System.out.println("----------------------");
         * Iterator<Map.Entry<String, String>> it = entries.iterator();
         * while (it.hasNext()){
         * Map.Entry<String, String> entry = it.next();
         * String key = entry.getKey();
         * String value = entry.getValue();
         * System.out.println(key+","+value);
         * }
         * System.out.println("----------------------");
         * //第三种：forEach（BiConsumer）JDK8 版本新增的遍历的方法。
         * map.forEach((String key, String value)->{
         * System.out.println(key+"="+value);
         * });
         * System.out.println("----------------------");
         */
        // 第四种：values（）；获取map集合中所有的值，返回到一个Collection集合中。
        // forEach（）；
        Collection<String> values = map.values();
        values.forEach((String value) -> {
            System.out.println(value);
        });
    }
}
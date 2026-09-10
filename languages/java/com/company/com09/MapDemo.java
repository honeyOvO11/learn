package com.company.com09;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Map 接口方法：
 * void put(Object key, Object value)
 * Object get(Object key)
 * void clear()
 * 添加一对数据
 * 根据键获取值
 * 清空集合元素
 * Object remove(Object key)
 * 根据键删除一对数据，返回被删除的值
 * 54
 * int size()
 * 获取集合中的长度
 * boolean containsKey(Object key) 判断集合中是否包含指定的键
 * boolean containsValue(Object value) 判断集合中是否包含指定的值
 * Collection<V> values()
 * 获取集合中所有的值，保存到单列集合
 * String replace（Object key,Object value）将集合中 key 所映射的值修改为value
 */
public class MapDemo {
    public static void main(String[] args) {
        // 创建HashMap 集合对象
        // Map<String,String> map = new HashMap<>();
        HashMap<String, String> map = new HashMap<>();
        // void put(Object key, Object value) 添加一对数据（键值映射）
        // Map 集合中的键是唯一的、值可以重复
        map.put("s01", "张三");
        map.put("s02", "王五");
        map.put("s03", "赵六");
        // 使用新值将老值替换。并返回老值
        String oldValue = map.put("s01", "李四");
        System.out.println(oldValue);
        System.out.println(map);
        // 有时内容不同，哈希值相同
        // System.out.println("重地".hashCode());
        // System.out.println("通话".hashCode());
        // method01(map);
    }

    private static void method01(Map<String, String> map) {
        // int size() 获取集合中的长度
        System.out.println(map.size());
        // Object get(Object key) 根据键获取值
        String value = map.get("s02");
        System.out.println(value);
        // boolean containsKey(Object key) 判断集合中是否包含指定的键
        System.out.println(map.containsKey("s02"));
        System.out.println(map.containsKey("s05"));
        // boolean containsValue(Object value) 判断集合中是否包含指定的值
        System.out.println(map.containsValue("王五"));
        System.out.println(map.containsValue("周七"));
        // V remove(Object key)根据键删除一对数据，返回被删除的值
        String value2 = map.remove("s03");
        System.out.println(value2);
        System.out.println(map);
        // Collection<V> values() 获取集合中所有的值，保存到单列集合
        Collection<String> values = map.values();
        System.out.println(values);
        // String replace（Object key,Object value）
        // 将集合中key所映射的值修改为value
        map.replace("s02", "田老八");
        System.out.println(map);
        // void clear()清空集合元素
        map.clear();
        System.out.println(map);
    }
}
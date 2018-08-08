package com.lxf.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LXF
 * @date 2018/2/1 15:04
 */
public class MapDemo {

    volatile int i = 1;

    public static void main(String[] args) {
        // 2 *  2 ^ 4
        System.out.println(8 << 5);  // ----> 1000  --->  100000000
        System.out.println(8 >> 2); //   8的二进制 -->1000 --->右移移动 ---->10
//        0 ^ 1 得 1
//        1 ^ 1 得 0
//        0 ^ 0 得 0
//        1 ^ 0 得 1

        //右移一位表示除2 两位除4

//        >>：带符号右移。正数右移高位补0，负数右移高位补1。比如：
//
//        4 >> 1，结果是2；-4 >> 1，结果是-2。-2 >> 1，结果是-1。
//
//        >>>：无符号右移。无论是正数还是负数，高位通通补0。
//
//        对于正数而言，>>和>>>没区别。
//
//        对于负数而言，-2 >>> 1，结果是2147483647（Integer.MAX_VALUE），-1 >>> 1，结果是2147483647（Integer.MAX_VALUE）。
//
//        所以，要判断两个数符号是否相同时，可以这么干：
//
//        return ((a >> 31) ^ (b >> 31)) == 0;
        // 16 / (2 ^ 2)
        // 10000
        System.out.println("ss" + (16 >>> 2));
//
//        Object h = new Object();
//        System.out.println("h.hashCode() is " + h.hashCode());
        int a = 0;
        System.out.println("a is " + a);

        Map<String, String> map = new HashMap<>();
        map.put("1", "22");
        map.put("2", "33");
        map.put("3", "33");
        map.put("4", "33");
        map.put("5", "33");
        map.put("6", "33");
//        map.computeIfAbsent()

        HashMap<String, String> map2 = new HashMap<>();
        map2.put("1", "22");
        map2.put("2", "33");
        map2.put("3", "33");
        map2.put("4", "33");
        map2.put("5", "33");
        map2.put("6", "33");

        map2.forEach((k, v) -> {
            System.out.println("key" + k);
            System.out.println("value" + v);
        });


//        System.out.println(map.toString());
//        map2.computeIfAbsent();


//        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
//        while(it.hasNext()) {
//            System.out.println(it.next().getValue());
//        }

//        map.entrySet().forEach(entry -> System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue()));
//
//        map.keySet().forEach(key -> System.out.println("map.get(" + key + ") = " + map.get(key)));
//
//        map.keySet().forEach(System.out::println);
//        map.entrySet().iterator().forEachRemaining(item -> System.out.println("key:value=" + item.getKey() + ":" + item.getValue()));
    }
}

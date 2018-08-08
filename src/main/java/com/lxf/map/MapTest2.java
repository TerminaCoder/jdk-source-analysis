package com.lxf.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author created by LXF on 2018/5/23 23:48
 */
public class MapTest2 {
    public static void main(String[] args) {
        // 操作Map部分
        Map<String, Integer> items = new HashMap<>();
        items.put("小白", 10);
        items.put("小文", 20);
        items.put("小君", 30);
        items.put("KD", 40);
        items.put("ws", 50);
        items.put("XJ", 60);
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            System.err.println("使用java8之前的版本/姓名 : " + entry.getKey() + " 分数 : " + entry.getValue());
        }

        //java8版本
        items.forEach((k, v) -> {
            System.err.println("使用java8循环 /姓名 : " + k + " 分数 : " + v);
        });

        items.forEach((k, v) -> {
            if (k.equals("小文")) {
                System.out.println("hello " + k);
            }
        });

        System.out.println("------华丽的分割线-----");
    }
}

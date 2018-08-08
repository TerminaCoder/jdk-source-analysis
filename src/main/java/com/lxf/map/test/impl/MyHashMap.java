package com.lxf.map.test.impl;

import com.lxf.map.test.IMyHashMap;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LXF
 * @date 2018/3/21 9:07
 */
public class MyHashMap<K, V> implements IMyHashMap<K, V>, Cloneable, Serializable {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        //限定变量的类型
        IMyHashMap<String, Integer> myHashMap = new MyHashMap();
        myHashMap.put("name", 1);
        Map map = new HashMap();
    }

//    void f(HashMap map) {
//        map.put("key", "value");
//    }

    @Override
    public V get(K k) {
        return null;
    }

    @Override
    public void put(K k, V v) {
        System.out.println(" key  is " + k + " " + "value is " + v);
    }
}

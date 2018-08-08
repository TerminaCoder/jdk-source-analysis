package com.lxf.map.resize;

import java.util.HashMap;
import java.util.Map;

import static com.sun.xml.internal.fastinfoset.util.ValueArray.MAXIMUM_CAPACITY;

/**
 * @author LXF
 * @date 2018/3/21 17:37
 */
public class MainTest {

    public static void initHashMap() {
        HashMap<String, String> map = new HashMap(2);
        map.put("1", "2");
        map.put("1", "3");
        System.out.println(map.put("1", "3"));
        // a=a|b
//        int a = 2;
//        int b = a -1;
//        System.out.println(b |= a);
//        System.out.println(tableSizeFor(9));
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public static void main(String[] args) {
//        initHashMap();
        Map<MapKey, String> map = new HashMap();

        //第一阶段
        for (int i = 0; i < 6; i++) {
            map.put(new MapKey(String.valueOf(i)), "A");
        }


        //第二阶段
        for (int i = 0; i < 10; i++) {
            map.put(new MapKey(String.valueOf(i)), "A");
        }


        //第三阶段
        for (int i = 0; i < 50; i++) {
            map.put(new MapKey(String.valueOf(i)), "A");
        }


        //第四阶段
        map.put(new MapKey("X"), "B");
        map.put(new MapKey("Y"), "B");
        map.put(new MapKey("Z"), "B");

        System.out.println(map);
    }
}
package com.lxf.collection.set;

import java.util.*;

/**
 * @author LXF
 * @date 2018/2/1 11:31
 */
public class HashSetDemo {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("10");
        set.add("20");
        set.add("30");
        set.add("30");

        Iterator<String> it =  set.iterator();

        while(it.hasNext()) {
            System.out.println(it.next());
        }



        //set.forEach(System.out::println);
    }
}

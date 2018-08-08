package com.lxf.collection.set;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author LXF
 * @date 2018/2/1 15:35
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        Set<String> treeSet = new TreeSet<>();

        treeSet.add("1");

        treeSet.add("3");

        treeSet.add("2");

        treeSet.forEach(System.out::println);



    }
}

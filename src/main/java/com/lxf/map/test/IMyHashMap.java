package com.lxf.map.test;

/**
 * @author LXF
 * @date 2018/3/21 9:09
 */
public interface IMyHashMap<K, V> {
    V get(K k);

    void put(K k, V v);
//    K set(K k);
}

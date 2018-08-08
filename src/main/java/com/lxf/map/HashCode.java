package com.lxf.map;

import javax.swing.tree.TreeNode;

/**
 * @author LXF
 * @date 2018/3/19 16:51
 * http://blog.csdn.net/richard_jason/article/details/53887222
 * http://blog.csdn.net/fan2012huan/article/details/51088211
 */
public class HashCode {
    public static void main(String[] args) {
        /**
         * 这里的Hash算法本质上就是三步：
         * 1.取key的hashCode值(native方法)、
         * 2.高位运算(>> 16)、
         * 3.取模运算(& (表的长度 - 1))。
         *
         */
        String a = "特图上";
        System.out.println(a.hashCode());
        String b = "特图下";
        System.out.println(b.hashCode());

        // 48 / (16^2)
        System.out.println(28872453 >> 16);
        System.out.println(Integer.toBinaryString(28872453));
        // 10000000
        // 10000000 相当于128 / (2^6)
        System.out.println(Integer.toBinaryString(128));


//        0 ^ 1 得 1
//        1 ^ 1 得 0
//        0 ^ 0 得 0
//        1 ^ 0 得 1

        //2 & (16 - 1) 等价于 2 % 16
        System.out.println(440 & (16 - 1));



    }

//    public V put(K key, V value) {
//
//        return putVal(hash(key), key, value, false, true);
//    }
//    /**
//     *生成hash的方法
//     */
//    static final int hash(Object key) {
//        int h;
//        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
//    }
//
//    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,boolean evict) {
//        Node<K,V>[] tab; Node<K,V> p; int n, i;
//        //判断table是否为空，
//        if ((tab = table) == null || (n = tab.length) == 0)
//            n = (tab = resize()).length;//创建一个新的table数组，并且获取该数组的长度
//        //根据键值key计算hash值得到插入的数组索引i，如果table[i]==null，直接新建节点添加
//        if ((p = tab[i = (n - 1) & hash]) == null)
//            tab[i] = newNode(hash, key, value, null);
//        else {//如果对应的节点存在
//            Node<K,V> e; K k;
//            //判断table[i]的首个元素是否和key一样，如果相同直接覆盖value
//            if (p.hash == hash &&
//                    ((k = p.key) == key || (key != null && key.equals(k))))
//                e = p;
//                //判断table[i] 是否为treeNode，即table[i] 是否是红黑树，如果是红黑树，则直接在树中插入键值对
//            else if (p instanceof TreeNode)
//                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
//                // 该链为链表
//            else {
//                //遍历table[i]，判断链表长度是否大于TREEIFY_THRESHOLD(默认值为8)，大于8的话把链表转换为红黑树，在红黑树中执行插入操作，否则进行链表的插入操作；遍历过程中若发现key已经存在直接覆盖value即可；
//                for (int binCount = 0; ; ++binCount) {
//                    if ((e = p.next) == null) {
//                        p.next = newNode(hash, key, value, null);
//                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
//                            treeifyBin(tab, hash);
//                        break;
//                    }
//                    if (e.hash == hash &&
//                            ((k = e.key) == key || (key != null && key.equals(k))))
//                        break;
//                    p = e;
//                }
//            }
//            // 写入
//            if (e != null) { // existing mapping for key
//                V oldValue = e.value;
//                if (!onlyIfAbsent || oldValue == null)
//                    e.value = value;
//                afterNodeAccess(e);
//                return oldValue;
//            }
//        }
//        ++modCount;
//        // 插入成功后，判断实际存在的键值对数量size是否超多了最大容量threshold，如果超过，进行扩容
//        if (++size > threshold)
//            resize();
//        afterNodeInsertion(evict);
//        return null;
//    }
}

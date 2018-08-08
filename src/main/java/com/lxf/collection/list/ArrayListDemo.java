package com.lxf.collection.list;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LXF
 * @date 2018/1/29 23:44
 */
public class ArrayListDemo {
    /***
     * ArrayList：实质就是一个会自动增长的数组 线程不安全
     * 1.查询效果比较高，增删动作的效率比较低,适用于查询比较频繁，增删动作比较少的元素管理的集合
     * 2.加载大批量的数据时，先进行手动扩容ensureCapacity(int minCapacity)这样可以提高效率
     *  https://www.cnblogs.com/springfor/p/3985333.html
     *
     * */

    public static void main(String[] args) {
        List<String> listDemo = new ArrayList<>();

        //增加 add
        listDemo.add("1");
        listDemo.add("2");
        listDemo.add("3");
        System.out.println(listDemo.toString());
        for (String temp : listDemo) {
            System.out.println(temp);
        }

        System.out.println("----------------");
        //删 remove
        //对象
        listDemo.remove("1");

        //序号
        listDemo.remove(1);
        for (String temp : listDemo) {
            System.out.println(temp);
        }

        System.out.println("----------------");
        //改 set
        listDemo.set(0, "1");
        for (String temp : listDemo) {
            System.out.println(temp);
        }
    }

    @Test
    public void test() {
        List<String> listDemo1 = new ArrayList<>();

        listDemo1.add("1");
        listDemo1.add("2");
        listDemo1.add("3");
        listDemo1.add("4");

        List<String> listDemo2 = new ArrayList<>();
        listDemo2.add("3");
        listDemo2.add("4");
        listDemo2.add("5");

//        for(Object o:objCollection){
//            someInfrastructure.output(o);
//        }
//        可以变成
//        objCollection.forEach(someInfrastructure::output);

        listDemo2.forEach(System.out::println);

//        listDemo1.addAll(listDemo2);
//
//        System.out.println(listDemo1.toString());
//
//        System.out.println("-----------------------");
//
//        listDemo1.removeAll(listDemo2);
//        System.out.println(listDemo1.toString());

        System.out.println("-----------------------");

        listDemo1.retainAll(listDemo2);
        System.out.println(listDemo1.toString());

//        Collections.sort(listDemo1, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return 0;
//            }
//        });

//        Collections.sort(listDemo1, (o1, o2) -> {
//                    return 1;
//                }
//        );
    }

    @Test
    public void test_2() {
        System.out.println(1 != 2);
        List<String> listDemo1 = new ArrayList<>();
    }

}

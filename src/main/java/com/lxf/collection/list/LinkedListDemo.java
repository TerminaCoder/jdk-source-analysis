package com.lxf.collection.list;

import java.util.Stack;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author LXF
 * @date 2018/1/31 16:45
 */
public class LinkedListDemo {
    /***
     * LinkedList 底层是用双向循环链表来实现 线程不安全
     * 1. 查询效率低，但是增删效率高，适用于增删动作的比较频繁，查询次数较少的元素管理的集合
     *
     *
     */

    public static void main(String[] args) throws InterruptedException {
        Stack<String> stack = new Stack<>();
        stack.push("4");
        stack.push("3");
        stack.push("2");
        stack.push("1");

        //stack.peek();//获取栈顶 不删除
        //stack.pop();//获取栈顶 并删除
        System.out.println(stack.pop());
        //System.out.println(stack.peek());
        System.out.println("===============");
        stack.forEach(System.out::println);
        //stack.peek();

        System.out.println("========队列=======");

        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        queue.offer("1");
        queue.offer("2");

        queue.put("3");

        //queue.peek();
        // queue.poll();


        String a = queue.take();//删除
        System.out.println("a is : " + a);
//        System.out.println( queue.poll());

        System.out.println("========队列333=======");
        queue.forEach(System.out::println);

        System.out.println("========队列SynchronousQueue=======");
        BlockingQueue<String> queue2 = new SynchronousQueue<>();
//        queue2.take();
        queue2.put("2");
        System.out.println();
        //queue2.forEach(System.out::println);
        System.out.println("========队列22SynchronousQueue=======");

//        new Thread(() -> {
//            try {
//                System.out.println("ddd" + queue2.take());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();

    }
}

package com.lxf.thread.currenttest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LXF
 * @date 2018/3/2 9:01
 */
public class LockDemo {
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread a = new Thread(LockDemo::test);
        a.setName("thread A");
        a.start();

        Thread b = new Thread(() -> {
            LockDemo.test();
        });
        b.setName("thread B");
        b.start();

    }

    private static void test() {
        if (lock.tryLock()) {
            try {
                System.out.println("获取锁的线程： " + Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println("释放锁的线程： " + Thread.currentThread().getName());
            }
        } else {
            System.out.println("没有获取锁的线程： " + Thread.currentThread().getName());
        }
    }
}

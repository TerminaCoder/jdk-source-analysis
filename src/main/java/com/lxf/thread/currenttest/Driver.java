package com.lxf.thread.currenttest;

import java.util.concurrent.CountDownLatch;

/**
 * @author LXF
 * @date 2018/3/2 11:29
 * 下面请看一个应用场景：
 * 有1个driver和5个worker，需要满足以下两点要求：
 * 当driver完成了全部的工作之后才允许worker们开始工作；
 * 当所有的worker都完成了自己的工作之后，driver主线程才能结束。
 */
public class Driver {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(5);


        // 依次创建并启动5个worker线程
        for (int i = 0; i < 5; ++i) {
            new Thread(new Worker(startSignal, doneSignal)).start();
        }

        System.out.println("Driver is doing something...");
        System.out.println("Driver is Finished, start all workers ...");
        startSignal.countDown(); // Driver执行完毕，发出开始信号，使所有的worker线程开始执行
        doneSignal.await(); // 等待所有的worker线程执行结束
        System.out.println("Finished.");
    }
}

class Worker implements Runnable {
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;

    Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    public void run() {
        try {
            startSignal.await(); // 等待Driver线程执行完毕，获得开始信号
            System.out.println("Working now ...");
            doneSignal.countDown(); // 当前worker执行完毕，释放一个完成信号
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

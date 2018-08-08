package com.lxf.thread.currenttest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author LXF
 * @date 2018/2/5 10:48
 */
public class CountDownLatchDemo {
    private static CountDownLatch count = new CountDownLatch(4);
    private static ExecutorService service = Executors.newFixedThreadPool(6);
    private static List<Future> futureList = new ArrayList<>();

    public static void main(String args[]) throws InterruptedException {

        for (int i = 0; i < 4; i++) {
            /**
             * () -> {
             // 模拟任务耗时
             try {
             int timer = new Random().nextInt(5);
             TimeUnit.SECONDS.sleep(timer);
             System.out.printf("%s时完成磁盘的统计任务,耗费%d秒.\n", new Date().toString(), timer);
             // 任务完成之后,计数器减一
             count.countDown();
             return 1;
             } catch (InterruptedException e) {
             e.printStackTrace();
             }
             }
             * */
            futureList.add(service.submit(() -> {
                        try {
                            int timer = new Random().nextInt(5);
                            TimeUnit.SECONDS.sleep(timer);
                            System.out.printf("%s时完成磁盘的统计任务,耗费%d秒.\n", new Date().toString(), timer);
                            // 任务完成之后,计数器减一
							//实际上减到0 就是唤醒所有线程
                            count.countDown();
                            return timer;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            return 0;
                        }
                    })
//                    new Callable<Object>() {
//                        @Override
//                        public Object call() throws Exception {
//
//                            return null;
//                        }
//                    }
            );
        }
        // 主线程一直被阻塞,直到count的计数器被设置为0, 线程接着往下执行
		//线程阻塞
        count.await();

        int sumAll = 0;

        for (Future a : futureList) {
            try {
                sumAll = (int) a.get() + sumAll;
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }


        int sumAll2 = (int) futureList.stream().map((cost) -> {
            try {
                return cost.get();
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }).reduce((cost, sum) -> {
            try {
                return (int) sum + (int) cost;
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }).get();

        System.out.println("sumAll2 " + sumAll2);

//        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
//        costBeforeTax.stream().map((cost) -> cost + .12 * cost).forEach(System.out::println);

//        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
//        double bill = costBeforeTax.stream().map((cost) -> cost + 0.12 * cost).reduce((sum, cost) -> { return sum + cost;}).get();
//        System.out.println("Total : " + bill);

//        futureList.forEach((a) -> {
//            try {
//                System.out.println(a.get());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//        });

        System.out.printf("%s时全部任务都完成,执行合并计算.\n", new Date().toString() + "total is :  " + sumAll);
        service.shutdown();
    }
}

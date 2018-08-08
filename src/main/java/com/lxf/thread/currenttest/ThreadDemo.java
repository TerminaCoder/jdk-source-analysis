package com.lxf.thread.currenttest;

import java.util.concurrent.*;

/**
 * @author LXF
 * @date 2018/2/5 15:08
 */
public class ThreadDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(() -> System.out.println("sss"));

        executorService.submit(() -> {
            System.out.println("yyy");
            return 1;
        });


        CompletionService<Object> completionService = new ExecutorCompletionService(executorService);

        Future future = completionService.submit(() -> {
            System.out.println("7777");
            return 1;
        });
        System.out.println(future.get());


        executorService.shutdown();
        //completionService.s
        //Callable
    }
}

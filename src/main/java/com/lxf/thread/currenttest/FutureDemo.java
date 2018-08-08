package com.lxf.thread.currenttest;

import java.util.concurrent.*;

/**
 * @author LXF
 * @date 2018/2/2 16:52
 */
public class FutureDemo {

    //Executor --》 ExecutorService --》 ThreadPoolExecutor
    //ThreadPoolExecutor

    //CompletionService --》 ExecutorCompletionService 处理线程池执行完的操作 封装 executor执行完返回的 Future 对象
    // 将Future放进队列
    private static ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        //executor.submit()
        CompletionService<Object> completionService = new ExecutorCompletionService<>(executor);

        completionService.submit(
            new Callable<Object>() {
                private String d = "eee";

                @Override
                public String call() throws Exception {
                    return d;
                }
            }
        );

        try {
            Future future = completionService.take();
            System.out.println(future.get());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}

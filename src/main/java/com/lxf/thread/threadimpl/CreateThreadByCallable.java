package com.lxf.thread.threadimpl;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author LXF
 * @date 2018/2/5 17:18
 */
public class CreateThreadByCallable implements Callable<Object> {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CreateThreadByCallable createThreadByCallable = new CreateThreadByCallable();

        /***
         * FutureTask implements RunnableFuture接口   RunnableFuture<V> extends Runnable, Future<V>
         *    FutureTask重写run方法 判断是 Callable类型 执行 call 方法
         * Callable<V> c = callable;
         * if (c != null && state == NEW) {
         *     V result;
         *     boolean ran;
         *     try {
         *         result = c.call();
         *         ran = true;
         *     } catch (Throwable ex) {
         *         result = null;
         *         ran = false;
         *         setException(ex);
         *     }
         *     if (ran)
         *         set(result);
         * }
         */

        FutureTask futureTask = new FutureTask<>(createThreadByCallable);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
    }

    @Override
    public Object call() throws Exception {
        return "我是Callable创建的线程";
    }
}

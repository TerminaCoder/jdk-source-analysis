# java多线程
## 1.实现线程的方式
### 1.1 继承Thread类
```java
/**
 * @author LXF
 * @date 2018/2/5 17:05
 */
public class CreateThreadByThread extends Thread {
    public static void main(String[] args) {
        CreateThreadByThread createThreadByThread = new CreateThreadByThread();
        /**
         * 线程执行方式  .start()--》 start0() (本地的方法) --》 start0()调用run() 方法
         * */

        createThreadByThread.start();
    }

    @Override
    public void run() {
        System.out.println("自定义run方法");
    }
}
```
### 1.2 实现Runnable接口
```java
/**
 * @author LXF
 * @date 2018/2/5 17:14
 */
public class CreateThreadByRunnable implements Runnable {
    public static void main(String[] args) {
        CreateThreadByRunnable createThreadByRunnable = new CreateThreadByRunnable();
        Thread thread = new Thread(createThreadByRunnable);
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("实现Runnable接口");
    }
}
```
### 1.3 通过Callable和FutureTask创建线程
```text
a. 创建Callable接口的实现类，并实现call()方法；
b. 创建Callable实现类的实例，使用FutureTask类来包装Callable对象，该FutureTask对象封装了该Callback对象的call()方法的返回值;
c. 使用FutureTask对象作为Thread对象的target创建并启动新线程；
d. 调用FutureTask对象的get()方法来获得子线程执行结束后的返回值。
```
```java
    /**
     * @author LXF
     * @date 2018/2/5 17:18
     */
    public class CreateThreadByCallable implements Callable<Object> {
        public static void main(String[] args) throws ExecutionException, InterruptedException {
            CreateThreadByCallable createThreadByCallable = new CreateThreadByCallable();
    
            /***
             * FutureTask implements RunnableFuture接口   
             * RunnableFuture<V> extends Runnable, Future<V>
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
    
            FutureTask futureTask = new FutureTask(createThreadByCallable);
            Thread thread = new Thread(futureTask);
            thread.start();
            System.out.println(futureTask.get());
        }
    
        @Override
        public Object call() throws Exception {
            return "我是Callable创建的线程";
        }
    }
```

## 2.线程池实现线程的各种操作
```text
1.为什么要使用线程池
1.1. 一些操作系统是有最大线程数量限制的。当运行的线程数量逼近这个值的时候，操作系统会变得不稳定。这也是我们要限制线程数量的原因.
1.2. 频繁创建和销毁线程会造成很大的开销，利用线程池对任务线程进行合理的分配。
（假设有100个线程，不使用线程池 我们就会创建100个线程来执行，利用线程池就可以仅创建10个，其他任务放进线程池的任务队列里等待，操作系统无需大量创建线程）

2.为什么不把线程池放入创建线程的方式之一呢
2.1.ExecutorService接口本身和“线程池”并没有直接关系，它的定义更接近“执行器”，而“使用线程管理的方式进行实现”只是其中的一种实现方式
2.2.即存在于线程池中容器的一定是Thread对象，而不是你要求运行的任务（所以叫线程池而不叫任务池也不叫对象池）；你要求运行的任务将被线程池分配给某一个空闲的Thread运行。
```
```java
/**
 * @author LXF
 * @date 2018/2/5 15:08
 */
public class ThreadDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(() -> {
            System.out.println("sss");
        });

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


        //completionService.s
        //Callable
    }
}
```


## 3.线程池的执行
```java
/**
*   包装 Callable<T> 对象和 Runnable对象为RunnableFuture<V>，在线程池统一调度
* */
interface RunnableFuture<V> extends Runnable, Future<V> {}
/**
* Callable 依赖这个用线程执行。
* */
class FutureTask<V> implements RunnableFuture<V> {}

/**
*   线程池类-》 abstractExecutorService是把Callable<T> 对象和 Runnable对象转换为了RunnableFuture<T>的实现类 FutureTask<T>
*  ,然后调用execute()方法, 而ThreadPoolExecutor类中是重写了execute()方法的，所以代码A中的es.submit实际上执行的是ThreadPoolExecutor.executor().  
*  而线程池的ThreadPoolExecutor.executor()内部 调用 addWorker执行  w = new Worker(firstTask); final Thread t = w.thread; t.start() 执行线程
*  
* */
class ThreadPoolExecutor extends AbstractExecutorService {} 
abstract class AbstractExecutorService implements ExecutorService {}
interface ExecutorService extends Executor {}

/**
* 线程结果处理类， 因为Callable 对象执行完后，会返回Future对象，用ExecutorCompletionService将结果封装在队列里面 ，然后统一处理
* */
class ExecutorCompletionService<V> implements CompletionService<V> {}
```


package com.lxf.thread.threadimpl;

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

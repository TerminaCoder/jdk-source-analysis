package com.lxf.thread.threadimpl;

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

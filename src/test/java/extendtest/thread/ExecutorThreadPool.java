package extendtest.thread;


/**
 * @author LXF
 * @date 2018/2/5 21:53
 * <p>
 * 虚线是实现 ，实线是继承
 * 接口 继承 接口, 其他不可继承，接口继承接口，不用实现它的接口的具体方法。
 * 抽象类 实现 接口 ，也可以不实现具体的方法. 由具体实现抽象类的方法来实现
 */
public class ExecutorThreadPool extends AbstractExecutor {

    @Override
    public void isShutDown() {

    }

    public void execute() {

    }

    public void execute(String name) {
        System.out.println(name);
    }

    public static void main(String[] args) {
        ExecutorThreadPool executorThreadPool = new ExecutorThreadPool();
        executorThreadPool.execute();
        executorThreadPool.isShutDown();
        executorThreadPool.test();
        executorThreadPool.execute("lxf");
    }
}

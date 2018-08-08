/**
 * @author LXF
 * @date 2018/1/30 9:49
 */
public class TreeDemo {
    //-Xss10240k
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("start Time is " + startTime);
        System.out.println(TreeDemo.add(80000));
        long endTime = System.currentTimeMillis();
        System.out.println("end Time is " + endTime);
        System.out.println("-------total time is--: " + (endTime - startTime));
    }

    private static long add(long i) {

        long sum;
        //递归截止的条件
        if (i == 1) {
            sum = 1;
        } else {
            sum = add(i - 1) + i;
        }

        return sum;
    }
}

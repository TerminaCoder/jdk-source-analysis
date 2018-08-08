import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LXF
 * @date 2018/1/29 23:44
 */
public class ArrayListDemo {
    /***
     * ArrayList：实质就是一个会自动增长的数组
     * 1.查询效果比较高，增删动作的效率比较低
     *https://www.cnblogs.com/springfor/p/3985333.html
     *
     * */

    public static void main(String[] args) {
        List<Object> list = new ArrayList();
        list.add("1");

        String[] strs = {};
        //strs
        strs = Arrays.copyOf(strs, 2);

        strs[0] = "1";
        strs[1] = "2";

        System.out.println(Arrays.toString(strs));

        int[] src = {1, 2, 3, 4};

        int[] dest = new int[9];

        System.arraycopy(src, 0, dest, 0, src.length);
        System.out.println(Arrays.toString(dest));

        String[] testStr = {"1", "2", "3"};
        ArrayListDemo.test(testStr);
        System.out.println("i is " + Arrays.toString(testStr));

        int a = 1;
        ArrayListDemo.test2(a);
        System.out.println("a is " + a);


        List<Integer> list2 = new ArrayList<>();
        list2.add(100);
        list2.add(200);
        ArrayListDemo.testList(list2);
        System.out.println("list2 is " + list2);
    }

    private static void test2(int a) {
        a = 2;
    }

    private static void test(String[]  testStr) {
        testStr[0] = "111";
    }

    private static void testList(List list) {
        list.set(0, 1);
    }
}

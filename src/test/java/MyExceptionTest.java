/**
 * @author created by LXF on 2018/5/24 0:06
 */
public class MyExceptionTest {
    public static void main(String[] args) {

        try {
            getName("lxf2");
        } catch (MyException e) {
            e.getMessage();
        }
    }

    private static void getName(String name) {
        if (name.equals("lxf")) {
            throw new MyException("除数不能是负数");
        } else {
            System.out.println("jj");
        }

    }
}

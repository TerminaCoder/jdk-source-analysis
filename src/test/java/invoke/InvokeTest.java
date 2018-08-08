package invoke;

import java.lang.reflect.Method;

/**
 * @author LXF
 * @date 2018/2/2 14:54
 */
public class InvokeTest {

    private void getText(String sql, int a) {
        System.out.println("sql " + sql);
        System.out.println("a " + a);
    }

    public static void main(String[] args) throws Exception {
        //Class t = InvokeTest.class;
        Class<?> t = Class.forName("invoke.InvokeTest");
        //Class t = obj1.getClass();

        Object obj1 = t.newInstance();

        Method funcName = t.getDeclaredMethod("getText", String.class, int.class);
//        Method funcName = t.getDeclaredMethod("getText", new Class[] {String.class, int.class});
        funcName.setAccessible(true);
        try {
            funcName.invoke(obj1, "s", 1);
//            funcName.invoke(obj1, new Object[] {"s", 1});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

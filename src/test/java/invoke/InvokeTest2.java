package invoke;

/**
 * @author LXF
 * @date 2018/4/10 16:34
 */

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author LXF
 * @date 2018/2/2 14:54
 */
public class InvokeTest2 {

    private void getText(String sql, int a) {
        System.out.println("sql " + sql);
        System.out.println("a " + a);
    }

    public static void main(String[] args) throws Exception {
        //Class t = InvokeTest.class;
        Class t = InvokeTest2.class;
        Method methods[] = t.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println("method: " + Arrays.toString(method.getParameterTypes()));
        }

//        Arrays.copyOf()

        InvokeTest2 invokeTest = (InvokeTest2) t.newInstance();
        invokeTest.getTextInvoke("7", 1);
    }

    private void getTextInvoke(String sql, int a) throws Exception {
        //jdk动态代理的基本原理
        //Class t = InvokeTest.class;
        Class t = Class.forName("invoke.InvokeTest");
        //Class t = obj1.getClass();

        Object obj1 = t.newInstance();
        //Method funcName = t.getDeclaredMethod("getText",String.class, int.class);

        Method funcName = t.getDeclaredMethod("getText", new Class[]{String.class, int.class});
        funcName.setAccessible(true);
        funcName.invoke(obj1, sql, a);
        //funcName.invoke(obj1, new Object[]{sql, a})
    }

}


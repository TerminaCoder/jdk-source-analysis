package test.Map;

/**
 * @author LXF
 * @date 2018/2/1 16:06
 */
public class IMapImpl implements IMap.IMapB, IMap {
    @Override
    public void a() {

    }

    @Override
    public void b() {

    }


    public void c() {
        System.out.println("c");
    }

    public static void main(String[] args) {
        IMap A = new IMapImpl();
        A.a();
        IMapB B = new IMapImpl();
        B.b();
    }
}

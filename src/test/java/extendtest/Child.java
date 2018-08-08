package extendtest;

/**
 * @author LXF
 * @date 2018/2/2 21:57
 */
public class Child extends Parent {
    public void getText() {
        System.out.println("get text child");
    }

    @Override
    public void getSql() {
        System.out.println("get sql child");
    }

    public static void main(String[] args) {
        Child child = new Child();
        child.getSql();
        child.getText();

    }
}

/**
 * @author created by LXF on 2018/5/24 0:04
 */
public class MyException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    String message; // 定义String类型变量

    public MyException(String ErrorMessagr) { // 父类方法
        this.message = ErrorMessagr;
        System.out.println("程序发生了其他的异常222");
    }

    public String getMessage() { // 覆盖getMessage()方法
        return message;
    }
}

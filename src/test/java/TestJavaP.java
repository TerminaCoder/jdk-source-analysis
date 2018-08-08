/**
 * @author LXF
 * @date 2018/1/30 17:24
 */
public class TestJavaP {
    //javap -c -v TestJavaP.class > p.txt
    public static void main(String[] args) {
        String jaasTemplate = "org.apache.kafka.common.security.scram.ScramLoginModule required username=\"%s\" password=\"%s\";";
        String jaasCfg = String.format(jaasTemplate, "2", "3");
        System.out.println(jaasCfg);
//        int a = 3;
//        int b = 3;
//        System.out.println("a" + a);
//        System.out.println("b" + b);
    }
}

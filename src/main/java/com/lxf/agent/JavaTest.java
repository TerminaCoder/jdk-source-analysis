package com.lxf.agent;

/**
 * @author created by LXF on 2018/4/26 10:38
 */
public class JavaTest {

    /**
     * -javaagent:xxx.jar
     *
     * 会在main方法之前预先执行premain方法
     * Agent 类必须打成jar包，然后里面的 META-INF/MAINIFEST.MF 必须包含 Premain-Class这个属性
     * public static void premain(String args, Instrumentation inst)
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("开始");
    }
}

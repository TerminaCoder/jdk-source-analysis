package com.lxf.map.test;

/**
 * @author LXF
 * @date 2018/3/21 9:33
 */
public class StaticInnerClass {
    StaticInnerClass() {
        System.out.println("staticInnerClass");
    }

     class InnerClass {
        InnerClass() {
            System.out.println("InnerClass");
        }
    }

    public static void main(String[] args) {
        StaticInnerClass staticInnerClass = new StaticInnerClass();
        InnerClass innerClass = staticInnerClass.new InnerClass();
    }
}

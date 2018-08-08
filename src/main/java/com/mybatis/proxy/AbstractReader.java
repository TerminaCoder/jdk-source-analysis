package com.mybatis.proxy;

/**
 * @author LXF
 * @date 2018/4/1 2:54
 */
public abstract class AbstractReader implements IReader {
    public void one() {
        System.out.println("第一步");
    }

    public void two() {
        System.out.println("第二步");
    }

    public abstract void three();
}

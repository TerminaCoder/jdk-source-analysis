package com.mybatis.proxy.impl;

import com.mybatis.proxy.AbstractReader;

/**
 * @author LXF
 * @date 2018/3/31 19:13
 */
public class Book extends AbstractReader {
    @Override
    public <T> T getContent(Class<T> className) {
        System.out.println("读书");
        try {
            return className.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void three() {
        System.out.println("通天塔999");
    }
}

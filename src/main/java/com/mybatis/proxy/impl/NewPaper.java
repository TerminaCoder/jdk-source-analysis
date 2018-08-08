package com.mybatis.proxy.impl;

import com.mybatis.proxy.IReader;

/**
 * @author LXF
 * @date 2018/4/1 2:45
 */
public class NewPaper implements IReader {
    @Override
    public <T> T getContent(Class<T> className) {
        try {
            return className.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void one() {

    }

    @Override
    public void two() {

    }

    @Override
    public void three() {

    }
}

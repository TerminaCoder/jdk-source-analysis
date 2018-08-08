package com.mybatis.proxy;

import java.util.ArrayList;

/**
 * @author LXF
 * @date 2018/3/31 19:13
 */
public interface IReader {
    <T> T getContent(Class<T> className);
    void one();
    void two();
    void three();
}

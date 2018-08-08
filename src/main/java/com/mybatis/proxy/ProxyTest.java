package com.mybatis.proxy;

import com.mybatis.proxy.impl.Book;

import java.lang.reflect.Proxy;

/**
 * @author LXF
 * @date 2018/3/31 19:14
 */
public class ProxyTest {
    public static void main(String[] args) throws Exception {
//        ClassLoader loader,Class<?>[] interfaces,InvocationHandler h
//        ProxyTest proxyTest = new ProxyTest();
//        IReader iReader = proxyTest.getInstance(Book.class.newInstance());
//        iReader.one();
//        iReader.two();
//        iReader.three();
//        iReader.getContent(RedisTest.class);
//        IReader iReader = new Book();
//        iReader.one();

    }

    // new Class<?>[]{className},

    //@SuppressWarnings("unchecked")
    private <T> T getInstance(T object) {
        return (T) Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                (proxy, method, arg) -> method.invoke(object, arg)
        );
    }
}

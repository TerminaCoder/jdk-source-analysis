package com.mybatis.test;

import com.mybatis.test.impl.Woman;

/**
 * @author LXF
 * @date 2018/3/31 18:46
 */
public class PersonTest {
    public static void main(String[] args) {
        //Ctrl + Alt + B
        getPerson().getName();
    }

    private static IPerson getPerson() {
        return new Woman();
    }
}

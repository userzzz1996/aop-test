package com.zzz.thread.test;

import org.assertj.core.data.Index;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Title: TotalTest
 * @Package: com.zzz.aop.thread.test
 * @Description:
 * @Author: zzz
 * @Date: created 2020/1/2 11:17
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
public class TotalTest {

    public static void main(String[] args) {
        String x = "123";
        String m = "1"+"23";
        //字符串拼接也会放在常量池中 常量池中有一个stringtable，是一个hashset。

        AtomicInteger atomicInteger = new AtomicInteger(0);
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.getAndIncrement());
    }
}

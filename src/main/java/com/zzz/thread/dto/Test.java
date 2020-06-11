package com.zzz.thread.dto;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Title: Test
 * @Package: com.zzz.aop.thread.dto
 * @Description:
 * @Author: zzz
 * @Date: created 2019/12/19 18:27
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
public class Test {

    public static void main(String[] args) {
        BufferAare bufferAare = new BufferAare();
        Thread pro1 = new Productor(bufferAare);
        Thread pro2 = new Productor(bufferAare);
        Thread con1 = new Consumer(bufferAare);
        Thread con2 = new Consumer(bufferAare);
        pro1.start();
        pro2.start();
        con1.start();
        con2.start();
        //成员方法
        //pro2.interrupt();
        //interrupted()检测该线程是否被中断，静态方法
        boolean b = Thread.interrupted();
        System.out.println(b);
        try {
            //join()方法，当pro1线程结束后才会结束主线程,会造成阻塞
            pro1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main stop");
    }
}

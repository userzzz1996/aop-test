package com.zzz.thread.dto;

import java.util.concurrent.CountDownLatch;

/**
 * @Title: CountDownLatchTest
 * @Package: com.zzz.aop.thread.dto
 * @Description:
 * @Author: zzz
 * @Date: created 2019/12/24 17:00
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
public class CountDownLatchTest extends Thread{

    //闭锁
    private CountDownLatch countDownLatch;

    private String name;

    private Long time;

    public CountDownLatchTest(CountDownLatch countDownLatch, String name, Long time) {
        this.countDownLatch = countDownLatch;
        this.name = name;
        this.time = time;
    }
    @Override
    public void run(){
        System.out.println(name+"开始");
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
        System.out.println(name+"等待");
    }

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(4);
        CountDownLatchTest sks = new CountDownLatchTest(countDownLatch,"sks",1000L);
        CountDownLatchTest awm = new CountDownLatchTest(countDownLatch,"awm",4000L);
        CountDownLatchTest m4 = new CountDownLatchTest(countDownLatch,"m4",7000L);
        CountDownLatchTest ak = new CountDownLatchTest(countDownLatch,"ak",5000L);
        sks.start();
        awm.start();
        m4.start();
        ak.start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("全部准备就绪，开始执行");
    }
}
